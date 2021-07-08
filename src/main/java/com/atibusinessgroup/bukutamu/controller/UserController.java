package com.atibusinessgroup.bukutamu.controller;

import com.atibusinessgroup.bukutamu.model.User;
import com.atibusinessgroup.bukutamu.model.dto.SearchUserListDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchUserListNonOptionalDTO;
import com.atibusinessgroup.bukutamu.repo.UserRepository;
import com.atibusinessgroup.bukutamu.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/list")
    public String listSearch(SearchUserListDTO searchUserListDTO, Model model, HttpSession httpSession) {
        return list(searchUserListDTO, model, httpSession);
    }

    @GetMapping("/user/list")
    public String list(SearchUserListDTO searchUserListDTO, Model model, HttpSession httpSession) {
        Pageable page = PageRequest.of(searchUserListDTO.getPage().get(), searchUserListDTO.getSize().get());
        Page<User> user = userRepository.findAll(
                searchUserListDTO.getUsername().get(),
                searchUserListDTO.getFirstName().get(),
                searchUserListDTO.getLastName().get(),
                page);
        model.addAttribute("user", user.getContent());

        SearchUserListNonOptionalDTO searchUserListNonOptionalDTO = new SearchUserListNonOptionalDTO();
        searchUserListNonOptionalDTO.setPage(searchUserListDTO.getPage().get());
        searchUserListNonOptionalDTO.setUsername(searchUserListDTO.getUsername().get());
        searchUserListNonOptionalDTO.setFirstName(searchUserListDTO.getFirstName().get());
        searchUserListNonOptionalDTO.setLastName(searchUserListDTO.getLastName().get());
        model.addAttribute("searchParam", searchUserListNonOptionalDTO);

        int totalData = Integer.parseInt((user.getTotalElements())+"");

        int currentPage = searchUserListDTO.getPage().get();
        int max = 5;
        double total = totalData;
        double size = searchUserListDTO.getSize().get();
        int totalPages = (int)Math.ceil(total/size);
        if (totalPages > 0) {
            List<Integer> pageNumbers = new ArrayList<Integer>();
            int cPage = currentPage+1;
            if(cPage-2 > 0 && totalPages > max) {
                int startPage = ((cPage+2) > totalPages ? (cPage+1) > totalPages ? (cPage-4) : (cPage-3) : (cPage-2));
                int endPage = ((cPage+2) > totalPages ? totalPages : (cPage+2));
                for(int i=startPage; i<=endPage; i++) {
                    pageNumbers.add(i);
                }
            }
            else {
                pageNumbers.addAll(IntStream.rangeClosed(1, totalPages > max ? max : totalPages).boxed().collect(Collectors.toList()));
            }
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalData", totalData);

        int itemPerPage = 10;
        int to =  ((searchUserListDTO.getPage().get()+1) * itemPerPage) > totalData ? totalData : ((searchUserListDTO.getPage().get()+1) * itemPerPage);
        int from = ((searchUserListDTO.getPage().get()) * itemPerPage + 1);
        String showingData = from + "-" + to;
        model.addAttribute("showingData", showingData);
        return "user/user-list";
    }

    @GetMapping("/user/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "user/create";
    }

    @GetMapping("/user/update/{id}")
    public String update(@PathVariable Long id, Model model){
        Optional<User> userOptional = userRepository.findById(id);
        User u = userOptional.get();
        u.setPassword(null);
        model.addAttribute("user", u);
        return "user/update";
    }

    @PostMapping("/user/form")
    public String form(@ModelAttribute User user, RedirectAttributes redirectAttributes){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(user.getId() != null){ // update
            Optional<User> u = userRepository.findById(user.getId());
            if(u.isPresent()) {
                if (user.getPassword() != null && !user.getPassword().contentEquals("")) {
                    String encodedPassword = passwordEncoder.encode(user.getPassword());
                    user.setPassword(encodedPassword);
                }
                else {
                    user.setPassword(u.get().getPassword());
                }
                userRepository.save(user);
            }
        }
        else {
            if(user.getPassword() == null || user.getPassword().contentEquals("")){
                redirectAttributes.addFlashAttribute("error", "Password tidak boleh kosong");
            }
            else{
                String encodedPassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
                userRepository.save(user);
            }
        }
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        System.out.println("Delete User");
        userRepository.deleteById(id);

        redirectAttributes.addFlashAttribute("deleted", true);
        return "redirect:/user/list";
    }

}
