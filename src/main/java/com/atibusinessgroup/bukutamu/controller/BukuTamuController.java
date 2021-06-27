package com.atibusinessgroup.bukutamu.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.model.dto.SearchGuestbookListDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchGuestbookListNonOptionalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.atibusinessgroup.bukutamu.repo.BukuTamuRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;

@Controller
public class BukuTamuController {

	@Autowired
	private BukuTamuRepository bukuTamuRepository;
	
	public static class BukuTamu{
		private String id;
		private String jenis;
		private String nama;
		private String jenisKelamin;
		private String tipeIdentitas;
		private String nomorIdentitas;
		private String alamat;
		private String keperluan;
		private String pihakYgDitemui;
		private String keterangan;
		private String noHp;
		private String noTelepon;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getJenis() {
			return jenis;
		}
		public void setJenis(String jenis) {
			this.jenis = jenis;
		}
		public String getNama() {
			return nama;
		}
		public void setNama(String nama) {
			this.nama = nama;
		}
		public String getJenisKelamin() {
			return jenisKelamin;
		}
		public void setJenisKelamin(String jenisKelamin) {
			this.jenisKelamin = jenisKelamin;
		}
		public String getTipeIdentitas() {
			return tipeIdentitas;
		}
		public void setTipeIdentitas(String tipeIdentitas) {
			this.tipeIdentitas = tipeIdentitas;
		}
		public String getNomorIdentitas() {
			return nomorIdentitas;
		}
		public void setNomorIdentitas(String nomorIdentitas) {
			this.nomorIdentitas = nomorIdentitas;
		}
		public String getAlamat() {
			return alamat;
		}
		public void setAlamat(String alamat) {
			this.alamat = alamat;
		}
		public String getKeperluan() {
			return keperluan;
		}
		public void setKeperluan(String keperluan) {
			this.keperluan = keperluan;
		}
		public String getPihakYgDitemui() {
			return pihakYgDitemui;
		}
		public void setPihakYgDitemui(String pihakYgDitemui) {
			this.pihakYgDitemui = pihakYgDitemui;
		}

		public String getKeterangan() {
			return keterangan;
		}

		public void setKeterangan(String keterangan) {
			this.keterangan = keterangan;
		}

		public String getNoHp() {
			return noHp;
		}

		public void setNoHp(String noHp) {
			this.noHp = noHp;
		}

		public String getNoTelepon() {
			return noTelepon;
		}

		public void setNoTelepon(String noTelepon) {
			this.noTelepon = noTelepon;
		}

		@Override
		public String toString() {
			return "BukuTamu [jenis=" + jenis + ", nama=" + nama + ", jenisKelamin=" + jenisKelamin + ", tipeIdentitas="
					+ tipeIdentitas + ", nomorIdentitas=" + nomorIdentitas + ", alamat=" + alamat + ", keperluan="
					+ keperluan + ", pihakYgDitemui=" + pihakYgDitemui + "]";
		}
		
		
	}

	@GetMapping("/guestbook")
	public String index(Model model){
		return "guestbook";
	}

	@PostMapping("/guestbook/list")
	public String listSearch(SearchGuestbookListDTO searchGuestbookListDTO, Model model, HttpSession httpSession) {
		return list(searchGuestbookListDTO, model, httpSession);
	}

	@GetMapping("/guestbook/list")
	public String list(SearchGuestbookListDTO searchGuestbookListDTO, Model model, HttpSession httpSession){
		Pageable page = PageRequest.of(searchGuestbookListDTO.getPage().get(), searchGuestbookListDTO.getSize().get());
		Page<com.atibusinessgroup.bukutamu.model.BukuTamu> getBukuTamu = bukuTamuRepository.findAll(page);
		model.addAttribute("bukuTamu", getBukuTamu.getContent());

		SearchGuestbookListNonOptionalDTO searchClaimListNonOptionalDTO = new SearchGuestbookListNonOptionalDTO();
		searchClaimListNonOptionalDTO.setPage(searchGuestbookListDTO.getPage().get());
		model.addAttribute("searchParam", searchClaimListNonOptionalDTO);

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
		com.atibusinessgroup.bukutamu.model.BukuTamu bt = new com.atibusinessgroup.bukutamu.model.BukuTamu();
		if(bukuTamu.getId() != null){
			bt = bukuTamuRepository.getOne(bukuTamu.getId());
		}
		bt.setId(UUID.randomUUID().toString());
		bt.setNama(bukuTamu.getNama());
		bt.setAlamat(bukuTamu.getAlamat());
		bt.setJenis(bukuTamu.getJenis());
		bt.setJenisKelamin(bukuTamu.getJenisKelamin());
		bt.setKeperluan(bukuTamu.getKeperluan());
		bt.setNomorIdentitas(bukuTamu.getNomorIdentitas());
		bt.setTipeIdentitas(bukuTamu.getTipeIdentitas());
		bt.setPihakYgDitemui(bukuTamu.getPihakYgDitemui());
		bt.setCreatedDate(Instant.now());
		bt.setKeterangan(bukuTamu.getKeterangan());
		bt.setNoHp(bukuTamu.getNoHp());
		bt.setNoTelepon(bukuTamu.getNoTelepon());
		bukuTamuRepository.save(bt);

		redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/guestbook";
    }
}