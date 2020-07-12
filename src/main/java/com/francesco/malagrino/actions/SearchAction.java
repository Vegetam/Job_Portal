package com.francesco.malagrino.actions;

import java.sql.SQLException;
import java.util.List;

import com.francesco.malagrino.dao.ProfileDao;
import com.francesco.malagrino.entity.Profile;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4221876198137015100L;
	private String query = "";
	private List<Profile> profilelist = null;
	boolean dataset = false;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String execute() {

		try {
			ProfileDao profiledao = new ProfileDao();
			profilelist = profiledao.search(query);
			dataset = true;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public List<Profile> getProfilelist() {
		return profilelist;
	}

	public void setProfilelist(List<Profile> profilelist) {
		this.profilelist = profilelist;
	}

	public boolean isDataset() {
		return dataset;
	}

	public void setDataset(boolean dataset) {
		this.dataset = dataset;
	}
}
