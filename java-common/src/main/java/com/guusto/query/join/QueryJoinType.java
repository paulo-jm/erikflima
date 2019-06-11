package com.guusto.query.join;

public enum QueryJoinType {
	JOIN, FETCH;

	public boolean isFetch() {
		return this.equals(FETCH);
	}

	public boolean isJoin() {
		return this.equals(JOIN);
	}
}
