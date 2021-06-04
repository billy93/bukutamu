package com.atibusinessgroup.bukutamu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BukuTamuController {

	public static class BukuTamu{
		private String jenis;
		private String nama;
		private String jenisKelamin;
		private String tipeIdentitas;
		private String nomorIdentitas;
		private String alamat;
		private String keperluan;
		private String pihakYgDitemui;
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
    public String submitBukuTamu(@ModelAttribute BukuTamu bukuTamu) {
		System.out.println(bukuTamu);
        return "redirect:/index";
    }
}
