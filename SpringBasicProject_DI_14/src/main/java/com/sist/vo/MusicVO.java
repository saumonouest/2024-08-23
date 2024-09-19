package com.sist.vo;
/*
 MNO                                       NOT NULL NUMBER(38)
 TITLE                                     NOT NULL VARCHAR2(4000)
 SINGER                                    NOT NULL VARCHAR2(4000)
 ALBUM                                              VARCHAR2(4000)
 POSTER                                    NOT NULL VARCHAR2(4000)
 STATE                                              VARCHAR2(26)
 IDCREMENT                                          NUMBER(38)
 */
public class MusicVO {
	private int mno, idcrement;
	private String title, singer, album, state;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
