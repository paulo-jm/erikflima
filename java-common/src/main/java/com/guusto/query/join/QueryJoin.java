package com.guusto.query.join;

import javax.persistence.criteria.JoinType;

public class QueryJoin {

	public static final class QueryFromBuilder {

		public static final QueryFromBuilder getInstance() {
			return new QueryFromBuilder();
		}

		private JoinType joinType;

		private QueryJoinType queryFromType;

		private String path;

		public QueryFromBuilder() {
			joinType = JoinType.INNER;
			queryFromType = QueryJoinType.JOIN;
		}

		public QueryFromBuilder joinType(JoinType joinType) {
			this.joinType = joinType;
			return this;
		}

		public QueryFromBuilder queryFromType(QueryJoinType queryFromType) {
			this.queryFromType = queryFromType;
			return this;
		}

		public QueryFromBuilder path(String path) {
			this.path = path;
			return this;
		}

		public QueryJoin build() {
			QueryJoin toBuild = new QueryJoin();
			toBuild.setJoinType(joinType);
			toBuild.setPath(path);
			toBuild.setQueryFromType(queryFromType);
			return toBuild;
		}

	}

	private JoinType joinType;

	private QueryJoinType queryFromType;

	private String path;

	public JoinType getJoinType() {
		return joinType;
	}

	public void setJoinType(JoinType joinType) {
		this.joinType = joinType;
	}

	public QueryJoinType getQueryFromType() {
		return queryFromType;
	}

	public void setQueryFromType(QueryJoinType queryFromType) {
		this.queryFromType = queryFromType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
