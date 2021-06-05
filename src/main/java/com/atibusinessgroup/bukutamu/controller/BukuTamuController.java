package com.atibusinessgroup.bukutamu.controller;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.atibusinessgroup.bukutamu.repo.BukuTamuRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		@Override
		public String toString() {
			return "BukuTamu [jenis=" + jenis + ", nama=" + nama + ", jenisKelamin=" + jenisKelamin + ", tipeIdentitas="
					+ tipeIdentitas + ", nomorIdentitas=" + nomorIdentitas + ", alamat=" + alamat + ", keperluan="
					+ keperluan + ", pihakYgDitemui=" + pihakYgDitemui + "]";
		}
		
		
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
		bukuTamuRepository.save(bt);

		redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }
}
