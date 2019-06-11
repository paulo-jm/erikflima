package com.guusto.search.model;

import java.util.Collection;

public class Paginator {

	public static class PaginatorBuild {

		public static PaginatorBuild getInstance() {
			return new PaginatorBuild();
		}

		public static PaginatorBuild getInstance(Paginator entity) {
			if (entity != null) {
				return new PaginatorBuild(entity);
			}
			return new PaginatorBuild();
		}

		private Paginator toBuild;

		public PaginatorBuild() {
			this.toBuild = new Paginator();
		}

		public PaginatorBuild(Paginator entity) {
			this.toBuild = entity;
		}

		public PaginatorBuild totalItens(Long totalItens) {
			this.toBuild.totalItens = totalItens;
			return this;
		}

		public PaginatorBuild itensPerPage(Long itensPerPage) {
			this.toBuild.itensPerPage = itensPerPage;
			return this;
		}

		public PaginatorBuild currentPage(Long currentPage) {
			this.toBuild.currentPage = currentPage;
			return this;
		}

		public PaginatorBuild results(Collection<?> results) {
			this.toBuild.results = results;
			return this;
		}

		public Paginator build() {
			return this.toBuild;
		}

	}

	private Long totalItens;

	private Long itensPerPage;

	private Long currentPage;

	private Collection<?> results;

	public Long getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(Long totalItens) {
		this.totalItens = totalItens;
	}

	public Long getItensPerPage() {
		return itensPerPage;
	}

	public void setItensPerPage(Long itensPerPage) {
		this.itensPerPage = itensPerPage;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public Collection<?> getResults() {
		return results;
	}

	public void setResults(Collection<?> results) {
		this.results = results;
	}

}
