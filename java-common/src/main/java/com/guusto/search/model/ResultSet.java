package com.guusto.search.model;

import java.util.Collection;

public class ResultSet {

	public static class ResultSetBuild {

		public static ResultSetBuild getInstance() {
			return new ResultSetBuild();
		}

		public static ResultSetBuild getInstance(ResultSet entity) {
			if (entity != null) {
				return new ResultSetBuild(entity);
			}
			return new ResultSetBuild();
		}

		private ResultSet toBuild;

		public ResultSetBuild() {
			this.toBuild = new ResultSet();
		}

		public ResultSetBuild(ResultSet entity) {
			this.toBuild = entity;
		}

		public ResultSetBuild numberOfRecords(Long numberOfRecords) {
			this.toBuild.numberOfRecords = numberOfRecords;
			return this;
		}
		
		public ResultSetBuild numberOfRecords(int numberOfRecords) {
			this.toBuild.numberOfRecords = Long.valueOf(numberOfRecords);
			return this;
		}

		public ResultSetBuild totalRecords(Long totalRecords) {
			this.toBuild.totalRecords = totalRecords;
			return this;
		}

		public ResultSetBuild results(Collection<?> results) {
			this.toBuild.results = results;
			return this;
		}

		public ResultSet build() {
			return this.toBuild;
		}

	}

	private Long totalRecords;

	private Long numberOfRecords;

	private Collection<?> results;

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Long getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(Long numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public Collection<?> getResults() {
		return results;
	}

	public void setResults(Collection<?> results) {
		this.results = results;
	}

}
