package ksmart42.khtour.dto;

public class Museum {
	private String large_chmus_cate_code;
	private String middle_chmus_cate_code;
	private String large_cate_name;
	private String ch_mus_name;
	
	public String getLarge_chmus_cate_code() {
		return large_chmus_cate_code;
	}
	public void setLarge_chmus_cate_code(String large_chmus_cate_code) {
		this.large_chmus_cate_code = large_chmus_cate_code;
	}
	public String getMiddle_chmus_cate_code() {
		return middle_chmus_cate_code;
	}
	public void setMiddle_chmus_cate_code(String middle_chmus_cate_code) {
		this.middle_chmus_cate_code = middle_chmus_cate_code;
	}
	public String getLarge_cate_name() {
		return large_cate_name;
	}
	public void setLarge_cate_name(String large_cate_name) {
		this.large_cate_name = large_cate_name;
	}
	public String getCh_mus_name() {
		return ch_mus_name;
	}
	public void setCh_mus_name(String ch_mus_name) {
		this.ch_mus_name = ch_mus_name;
	}
	
	@Override
	public String toString() {
		return "Museum [large_chmus_cate_code=" + large_chmus_cate_code + ", middle_chmus_cate_code="
				+ middle_chmus_cate_code + ", large_cate_name=" + large_cate_name + ", ch_mus_name=" + ch_mus_name
				+ "]";
	}
	
}
