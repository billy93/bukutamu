package com.atibusinessgroup.bukutamu.controller;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.Pegawai;
import com.atibusinessgroup.bukutamu.model.dto.SearchAppointmentListDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchAppointmentListNonOptionalDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchPegawaiListDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchPegawaiListNonOptionalDTO;
import com.atibusinessgroup.bukutamu.repo.AppointmentRepository;
import com.atibusinessgroup.bukutamu.repo.PegawaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PegawaiController {

    @Autowired
    private PegawaiRepository pegawaiRepository;

    @PostMapping("/pegawai/list")
    public String listSearch(SearchPegawaiListDTO searchPegawaiListDTO, Model model, HttpSession httpSession) {
        return list(searchPegawaiListDTO, model, httpSession);
    }

    @GetMapping("/pegawai/list")
    public String list(SearchPegawaiListDTO searchPegawaiListDTO, Model model, HttpSession httpSession) {
        Pageable page = PageRequest.of(searchPegawaiListDTO.getPage().get(), searchPegawaiListDTO.getSize().get());
        Page<Pegawai> pegawai = pegawaiRepository.findAll(
                searchPegawaiListDTO.getNama().get(),
                searchPegawaiListDTO.getJabatan().get(),
                page);
        model.addAttribute("pegawai", pegawai.getContent());

        SearchPegawaiListNonOptionalDTO searchPegawaiListNonOptionalDTO = new SearchPegawaiListNonOptionalDTO();
        searchPegawaiListNonOptionalDTO.setPage(searchPegawaiListDTO.getPage().get());
        searchPegawaiListNonOptionalDTO.setNama(searchPegawaiListDTO.getNama().get());
        searchPegawaiListNonOptionalDTO.setJabatan(searchPegawaiListDTO.getJabatan().get());
        model.addAttribute("searchParam", searchPegawaiListNonOptionalDTO);

        int totalData = Integer.parseInt((pegawai.getTotalElements())+"");

        int currentPage = searchPegawaiListDTO.getPage().get();
        int max = 5;
        double total = totalData;
        double size = searchPegawaiListDTO.getSize().get();
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
        int to =  ((searchPegawaiListDTO.getPage().get()+1) * itemPerPage) > totalData ? totalData : ((searchPegawaiListDTO.getPage().get()+1) * itemPerPage);
        int from = ((searchPegawaiListDTO.getPage().get()) * itemPerPage + 1);
        String showingData = from + "-" + to;
        model.addAttribute("showingData", showingData);
        return "pegawai/pegawai-list";
    }

    @GetMapping("/pegawai/create")
    public String create(Model model){
        model.addAttribute("pegawai", new Pegawai());
        return "pegawai/create";
    }

    @GetMapping("/pegawai/update/{id}")
    public String update(@PathVariable Long id, Model model){
        Optional<Pegawai> pegawaiOptional = pegawaiRepository.findById(id);
        model.addAttribute("pegawai", pegawaiOptional.get());
        return "pegawai/update";
    }

    @PostMapping("/pegawai/form")
    public String form(@ModelAttribute Pegawai pegawai){
        pegawaiRepository.save(pegawai);
        return "redirect:/pegawai/list";
    }

    @GetMapping("/pegawai/delete/{id}")
    public String delete(@PathVariable Long id){
        System.out.println("Delete Pegawai");
        pegawaiRepository.deleteById(id);
        return "redirect:/pegawai/list";
    }

}
