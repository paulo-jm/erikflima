package com.guusto.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.criteria.JoinType;
import javax.persistence.metamodel.Attribute;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.guusto.mapping.specification.Specification;
import com.guusto.query.join.QueryJoin;
import com.guusto.query.join.QueryJoinType;

public class PreparedQuery {

	private static final String DOT = ".";

	public static class PreparedQueryBuilder {

		public static final PreparedQueryBuilder getInstance(Class<?> genericType) {
			return new PreparedQueryBuilder(genericType);
		}

		public static final PreparedQueryBuilder getInstance(PreparedQuery preparedQuery) {
			return new PreparedQueryBuilder(preparedQuery);
		}

		protected PreparedQuery toBuild;

		public PreparedQueryBuilder(Class<?> genericType) {
			toBuild = new PreparedQuery(genericType);
		}

		public PreparedQueryBuilder(PreparedQuery toBuild) {
			this.toBuild = toBuild;
		}

		public PreparedQueryBuilder limit(Long limit) {
			toBuild.limit = limit;
			return this;
		}

		public PreparedQueryBuilder offset(Long offset) {
			toBuild.offest = offset;
			return this;
		}

		public PreparedQueryBuilder addJoin(QueryJoin queryFrom) {
			if (queryFrom != null) {

				if (toBuild.joins == null) {
					toBuild.joins = new ArrayList<>();
				}

				toBuild.joins.add(queryFrom);
			}
			return this;
		}

		public PreparedQueryBuilder addJoin(Attribute<?, ?> path, QueryJoinType queryFromType, JoinType joinType) {

			if (path != null) {
				return addJoin(QueryJoin.QueryFromBuilder.getInstance().joinType(joinType).path(path.getName())
						.queryFromType(queryFromType).build());
			}
			return this;
		}

		public PreparedQueryBuilder addJoin(QueryJoinType queryFromType, JoinType joinType, Attribute<?, ?>... path) {

			if (ArrayUtils.isNotEmpty(path)) {

				String[] result = Arrays.stream(path).filter(item -> item != null).map(item -> item.getName())
						.toArray(String[]::new);

				if (ArrayUtils.isNotEmpty(result)) {
					return addJoin(QueryJoin.QueryFromBuilder.getInstance().joinType(joinType)
							.path(String.join(PreparedQuery.DOT, result)).queryFromType(queryFromType).build());
				}

			}
			return this;
		}
		
		public PreparedQueryBuilder addJoin(String path, QueryJoinType queryFromType, JoinType joinType) {
			return addJoin(QueryJoin.QueryFromBuilder.getInstance().joinType(joinType).path(path)
					.queryFromType(queryFromType).build());
		}

		public PreparedQueryBuilder ordersBy(Map<String, String> ordersBy) {
			toBuild.ordersBy = ordersBy;
			return this;
		}

		public PreparedQueryBuilder addOrdersBy(String path, String direction) {
			if (StringUtils.isNotBlank(path) && StringUtils.isNotBlank(direction)) {

				if (toBuild.ordersBy == null) {
					toBuild.ordersBy = new HashMap<>();
				}

				toBuild.ordersBy.put(path, direction);
			}
			return this;
		}

		public PreparedQueryBuilder specification(Specification specification) {
			this.toBuild.specification = specification;
			return this;
		}

		public PreparedQuery build() {
			return toBuild;
		}

	}

	private Long limit;

	private Long offest;

	private Class<?> genericType;

	private Collection<QueryJoin> joins;

	private Specification specification;

	private Map<String, String> ordersBy;

	public PreparedQuery(Class<?> genericType) {
		this.genericType = genericType;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public Long getOffest() {
		return offest;
	}

	public void setOffest(Long offest) {
		this.offest = offest;
	}

	public Class<?> getGenericType() {
		return genericType;
	}

	public void setGenericType(Class<?> genericType) {
		this.genericType = genericType;
	}

	public Collection<QueryJoin> getJoins() {
		return joins;
	}

	public void setJoins(Collection<QueryJoin> joins) {
		this.joins = joins;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public Map<String, String> getOrdersBy() {
		return ordersBy;
	}

	public void setOrdersBy(Map<String, String> ordersBy) {
		this.ordersBy = ordersBy;
	}

}
