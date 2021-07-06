package com.atibusinessgroup.bukutamu.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.model.Pegawai;
import com.atibusinessgroup.bukutamu.model.dto.BukuTamuDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchGuestbookListDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchGuestbookListNonOptionalDTO;
import com.atibusinessgroup.bukutamu.repo.PegawaiRepository;
import com.atibusinessgroup.bukutamu.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.atibusinessgroup.bukutamu.repo.BukuTamuRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;

@Controller
public class BukuTamuController {

	@Autowired
	private BukuTamuRepository bukuTamuRepository;
	@Autowired
	private PegawaiRepository pegawaiRepository;
	@Autowired
	private ExportService exportService;

	@GetMapping("/guestbook")
	public String index(Model model){
		List<Pegawai> pegawaiList = pegawaiRepository.findAll();
		model.addAttribute("pegawaiList", pegawaiList);

		model.addAttribute("bukuTamu", new com.atibusinessgroup.bukutamu.model.BukuTamu());
		return "guestbook";
	}

	@GetMapping("/guestbook/update/{id}")
	public String index(Model model, @PathVariable Long id){
		Optional<com.atibusinessgroup.bukutamu.model.BukuTamu> bukuTamu = bukuTamuRepository.findById(id);
		model.addAttribute("bukuTamu", bukuTamu.get());

		List<Pegawai> pegawaiList = pegawaiRepository.findAll();
		model.addAttribute("pegawaiList", pegawaiList);
		return "guestbook";
	}

	@PostMapping("/guestbook/list")
	public String listSearch(SearchGuestbookListDTO searchGuestbookListDTO, Model model, HttpSession httpSession) throws ParseException {
		return list(searchGuestbookListDTO, model, httpSession);
	}

	@PostMapping("/guestbook/list/export")
	public ResponseEntity<Resource> exportPolicyList(SearchGuestbookListDTO searchGuestbookListDTO) throws IOException, ParseException {
		Pageable page = PageRequest.of(searchGuestbookListDTO.getPage().get(), searchGuestbookListDTO.getSize().get());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

		Page<BukuTamuDTO> getBukuTamu = bukuTamuRepository.findAll(
					searchGuestbookListDTO.getJenis().get(),
					searchGuestbookListDTO.getNama().get(),
					searchGuestbookListDTO.getKeperluan().get(),
					searchGuestbookListDTO.getNoHp().get(),
					searchGuestbookListDTO.getNomorIdentitas().get(),
					searchGuestbookListDTO.getStartDate().get() != null && !searchGuestbookListDTO.getStartDate().get().contentEquals("") ? simpleDateFormat2.format(simpleDateFormat.parse(searchGuestbookListDTO.getStartDate().get())) : "null",
					searchGuestbookListDTO.getEndDate().get() != null && !searchGuestbookListDTO.getEndDate().get().contentEquals("") ? simpleDateFormat2.format(simpleDateFormat.parse(searchGuestbookListDTO.getEndDate().get())) : "null",
					page);


		List<BukuTamuDTO> bukuTamus = getBukuTamu.getContent();

		Resource file = exportService.exportBukuTamu(bukuTamus);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String filename = "BukuTamu_"+sdf.format(new Date())+".xlsx";
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\""+filename+"\"")
				.contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
//                .contentType(MediaType.APPLICATION_PDF)
				.contentLength(file.contentLength())
				.body(file);
	}

	@GetMapping("/guestbook/list")
	public String list(SearchGuestbookListDTO searchGuestbookListDTO, Model model, HttpSession httpSession) throws ParseException {
		Pageable page = PageRequest.of(searchGuestbookListDTO.getPage().get(), searchGuestbookListDTO.getSize().get());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

//		String startDate = "2021-07-02";
//		String endDate = "2021-07-03";
		String startDate = searchGuestbookListDTO.getStartDate().get() != null && !searchGuestbookListDTO.getStartDate().get().contentEquals("") ? simpleDateFormat2.format(simpleDateFormat.parse(searchGuestbookListDTO.getStartDate().get())) :"null";
		String endDate = searchGuestbookListDTO.getEndDate().get() != null && !searchGuestbookListDTO.getEndDate().get().contentEquals("") ? simpleDateFormat2.format(simpleDateFormat.parse(searchGuestbookListDTO.getEndDate().get())) : "null";
		Page<BukuTamuDTO> getBukuTamu = bukuTamuRepository.findAll(
				searchGuestbookListDTO.getJenis().get(),
				searchGuestbookListDTO.getNama().get(),
				searchGuestbookListDTO.getKeperluan().get(),
				searchGuestbookListDTO.getNoHp().get(),
				searchGuestbookListDTO.getNomorIdentitas().get(),
				startDate,
				endDate,
				page);

		List<BukuTamuDTO> bukuTamus = getBukuTamu.getContent();
		model.addAttribute("bukuTamu", bukuTamus);

		SearchGuestbookListNonOptionalDTO searchGuestbookListNonOptionalDTO = new SearchGuestbookListNonOptionalDTO();
		searchGuestbookListNonOptionalDTO.setPage(searchGuestbookListDTO.getPage().get());
		searchGuestbookListNonOptionalDTO.setJenis(searchGuestbookListDTO.getJenis().get());
		searchGuestbookListNonOptionalDTO.setNama(searchGuestbookListDTO.getNama().get());
		searchGuestbookListNonOptionalDTO.setKeperluan(searchGuestbookListDTO.getKeperluan().get());
		searchGuestbookListNonOptionalDTO.setNoHp(searchGuestbookListDTO.getNoHp().get());
		searchGuestbookListNonOptionalDTO.setNomorIdentitas(searchGuestbookListDTO.getNomorIdentitas().get());
		searchGuestbookListNonOptionalDTO.setStartDate(searchGuestbookListDTO.getStartDate().get());
		searchGuestbookListNonOptionalDTO.setEndDate(searchGuestbookListDTO.getEndDate().get());
		model.addAttribute("searchParam", searchGuestbookListNonOptionalDTO);

		int totalData = Integer.parseInt((getBukuTamu.getTotalElements())+"");

		int currentPage = searchGuestbookListDTO.getPage().get();
		int max = 5;
		double total = totalData;
		double size = searchGuestbookListDTO.getSize().get();
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
		int to =  ((searchGuestbookListDTO.getPage().get()+1) * itemPerPage) > totalData ? totalData : ((searchGuestbookListDTO.getPage().get()+1) * itemPerPage);
		int from = ((searchGuestbookListDTO.getPage().get()) * itemPerPage + 1);
		String showingData = from + "-" + to;
		model.addAttribute("showingData", showingData);
		return "guestbook-list";
	}

	@PostMapping("/bukutamu")
    public String submitBukuTamu(@ModelAttribute BukuTamu bukuTamu, RedirectAttributes redirectAttributes) {
		if(bukuTamu.getId() != null){
			BukuTamu bt = bukuTamuRepository.getOne(bukuTamu.getId());
			bukuTamu.setCreatedDate(bt.getCreatedDate());
		}
		else {
			bukuTamu.setCreatedDate(Instant.now());
		}
		bukuTamuRepository.save(bukuTamu);

		redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/guestbook";
    }

	@GetMapping("/guestbook/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
		bukuTamuRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("deleted", true);

		return "redirect:/guestbook/list";
	}
}