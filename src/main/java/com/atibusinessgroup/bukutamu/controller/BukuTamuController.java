package com.atibusinessgroup.bukutamu.controller;

import java.io.IOException;
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
		List<Pegawai> pegawaiList = pegawaiRepository.findAll();
		model.addAttribute("pegawaiList", pegawaiList);

		model.addAttribute("bukuTamu", new com.atibusinessgroup.bukutamu.model.BukuTamu());
		return "guestbook";
	}

	@GetMapping("/guestbook/update/{id}")
	public String index(Model model, @PathVariable String id){
		Optional<com.atibusinessgroup.bukutamu.model.BukuTamu> bukuTamu = bukuTamuRepository.findById(id);
		model.addAttribute("bukuTamu", bukuTamu.get());

		List<Pegawai> pegawaiList = pegawaiRepository.findAll();
		model.addAttribute("pegawaiList", pegawaiList);
		return "guestbook";
	}

	@PostMapping("/guestbook/list")
	public String listSearch(SearchGuestbookListDTO searchGuestbookListDTO, Model model, HttpSession httpSession) {
		return list(searchGuestbookListDTO, model, httpSession);
	}

	@PostMapping("/guestbook/list/export")
	public ResponseEntity<Resource> exportPolicyList(SearchGuestbookListDTO searchGuestbookListDTO) throws IOException {
		Pageable page = PageRequest.of(searchGuestbookListDTO.getPage().get(), searchGuestbookListDTO.getSize().get());

		Page<BukuTamuDTO> getBukuTamu = bukuTamuRepository.findAll(
				searchGuestbookListDTO.getJenis().get(),
				searchGuestbookListDTO.getNama().get(),
				searchGuestbookListDTO.getKeperluan().get(),
				searchGuestbookListDTO.getNoHp().get(),
				searchGuestbookListDTO.getNomorIdentitas().get(),
				page);
		Resource file = exportService.exportBukuTamu(getBukuTamu.getContent());

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
	public String list(SearchGuestbookListDTO searchGuestbookListDTO, Model model, HttpSession httpSession){
		Pageable page = PageRequest.of(searchGuestbookListDTO.getPage().get(), searchGuestbookListDTO.getSize().get());
		Page<BukuTamuDTO> getBukuTamu = bukuTamuRepository.findAll(
				searchGuestbookListDTO.getJenis().get(),
				searchGuestbookListDTO.getNama().get(),
				searchGuestbookListDTO.getKeperluan().get(),
				searchGuestbookListDTO.getNoHp().get(),
				searchGuestbookListDTO.getNomorIdentitas().get(),
				page);
		model.addAttribute("bukuTamu", getBukuTamu.getContent());

		SearchGuestbookListNonOptionalDTO searchGuestbookListNonOptionalDTO = new SearchGuestbookListNonOptionalDTO();
		searchGuestbookListNonOptionalDTO.setPage(searchGuestbookListDTO.getPage().get());
		searchGuestbookListNonOptionalDTO.setJenis(searchGuestbookListDTO.getJenis().get());
		searchGuestbookListNonOptionalDTO.setNama(searchGuestbookListDTO.getNama().get());
		searchGuestbookListNonOptionalDTO.setKeperluan(searchGuestbookListDTO.getKeperluan().get());
		searchGuestbookListNonOptionalDTO.setNoHp(searchGuestbookListDTO.getNoHp().get());
		searchGuestbookListNonOptionalDTO.setNomorIdentitas(searchGuestbookListDTO.getNomorIdentitas().get());
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
		com.atibusinessgroup.bukutamu.model.BukuTamu bt = new com.atibusinessgroup.bukutamu.model.BukuTamu();
		if(bukuTamu.getId() != null){
			bt = bukuTamuRepository.getOne(bukuTamu.getId());
		}
		else {
			bt.setId(UUID.randomUUID().toString());
		}
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

	@GetMapping("/guestbook/delete/{id}")
	public String delete(@PathVariable String id,  RedirectAttributes redirectAttributes){
		bukuTamuRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("deleted", true);

		return "redirect:/guestbook/list";
	}
}