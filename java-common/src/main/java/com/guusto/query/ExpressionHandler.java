package com.guusto.query;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.guusto.query.join.QueryJoin;

public class ExpressionHandler {

	public static final ExpressionHandler getInstance(Root<?> root, Collection<QueryJoin> queryJoins) {
		ExpressionHandler expressionHandler = new ExpressionHandler();
		expressionHandler.setUpMapOfJoin(root, queryJoins);
		return expressionHandler;
	}

	public static final ExpressionHandler getInstance(Root<?> root, Collection<QueryJoin> queryJoins,
			boolean disableFetch) {
		ExpressionHandler expressionHandler = new ExpressionHandler();
		expressionHandler.setUpMapOfJoin(root, queryJoins, disableFetch);
		return expressionHandler;
	}

	private Map<String, From<?, ?>> mapOfJoin;

	private ExpressionHandler() {
		this.mapOfJoin = new HashMap<>();
	}

	public Expression<?> getExpression(Attribute<?, ?> attribute) {
		return getExpression(attribute.getName());
	}

	public Expression<?> getExpression(String path) {

		String key = getKeyJoin(path);

		From<?, ?> from = getJoin(key);

		if (from == null) {
			return getExpressionFromRoot(path);
		}

		return from.get(getAttr(path));

	}

	private Expression<?> getExpressionFromRoot(String path) {

		String[] paths = StringUtils.split(path, QueryConstant.POINT_REGEX);
		String[] joins = ArrayUtils.subarray(paths, 0, paths.length - 1);

		if (ArrayUtils.isEmpty(paths)) {
			return null;
		}

		String attr = getAttr(path);

		From<?, ?> from = getJoin(StringUtils.EMPTY);
		String key = null;

		for (String join : joins) {

			if (StringUtils.isNotBlank(key)) {
				key = String.format(QueryConstant.POINT_JOIN, key, join);
			} else {
				key = join;
			}

			if (mapOfJoin.containsKey(key)) {
				from = mapOfJoin.get(key);
			} else {
				from = from.join(join);
			}

		}

		return from.get(attr);
	}

	private String getKeyJoin(String path) {

		String[] strs = StringUtils.split(path, QueryConstant.POINT_REGEX);

		if (ArrayUtils.isEmpty(strs) || strs.length == 1) {
			return StringUtils.EMPTY;
		}

		String[] paths = ArrayUtils.subarray(strs, 0, strs.length - 1);

		return StringUtils.join(paths, QueryConstant.POINT_DELIMITER);

	}

	private String getAttr(String path) {

		String[] strs = StringUtils.split(path, QueryConstant.POINT_REGEX);

		if (ArrayUtils.isEmpty(strs)) {
			return StringUtils.EMPTY;
		}

		return strs[strs.length - 1];

	}

	private From<?, ?> getJoin(String key) {
		return mapOfJoin.get(key);
	}

	private void setUpMapOfJoin(Root<?> root, Collection<QueryJoin> queryJoins, boolean disableFetch) {
		setUpMapOfJoinRoot(root);
		setUpMapOfJoinQueryJoinTypeFech(root, queryJoins, disableFetch);
		setUpMapOfJoinQueryJoinTypeJoin(root, queryJoins);
	}

	private void setUpMapOfJoin(Root<?> root, Collection<QueryJoin> queryJoins) {
		setUpMapOfJoinRoot(root);
		setUpMapOfJoinQueryJoinTypeFech(root, queryJoins, Boolean.FALSE);
		setUpMapOfJoinQueryJoinTypeJoin(root, queryJoins);
	}

	private void setUpMapOfJoinRoot(Root<?> root) {
		mapOfJoin.put(StringUtils.EMPTY, root);
	}

	private void setUpMapOfJoinQueryJoinTypeJoin(Root<?> root, Collection<QueryJoin> queryJoins) {
		if (queryJoins != null && !queryJoins.isEmpty()) {
			for (QueryJoin queryJoin : queryJoins) {
				if (queryJoin != null && queryJoin.getQueryFromType() != null
						&& queryJoin.getQueryFromType().isJoin()) {
					setUpMapOfJoinQueryJoinTypeJoin(root, queryJoin);
				}
			}
		}
	}

	private void setUpMapOfJoinQueryJoinTypeJoin(Root<?> root, QueryJoin queryJoin) {

		String[] paths = StringUtils.split(queryJoin.getPath(), QueryConstant.POINT_REGEX);

		From<?, ?> from = root;
		String key = null;

		for (String join : paths) {

			if (StringUtils.isNotBlank(key)) {
				key = String.format(QueryConstant.POINT_JOIN, key, join);
			} else {
				key = join;
			}

			if (!mapOfJoin.containsKey(key)) {
				from = from.join(join, queryJoin.getJoinType());
				mapOfJoin.put(key, from);
			} else {
				from = mapOfJoin.get(key);
			}

		}

	}

	private void setUpMapOfJoinQueryJoinTypeFech(Root<?> root, Collection<QueryJoin> queryJoins, boolean disableFetch) {

		if (queryJoins != null && !queryJoins.isEmpty()) {
			for (QueryJoin queryJoin : queryJoins) {
				if (queryJoin != null && queryJoin.getQueryFromType() != null && queryJoin.getQueryFromType().isFetch()
						&& !disableFetch) {
					setUpMapOfJoinQueryJoinTypeFech(root, queryJoin);
				}
			}
		}

	}

	private void setUpMapOfJoinQueryJoinTypeFech(Root<?> root, QueryJoin queryJoin) {

		String[] paths = StringUtils.split(queryJoin.getPath(), QueryConstant.POINT_REGEX);

		From<?, ?> from = root;
		String key = null;

		for (String fetch : paths) {

			if (StringUtils.isNotBlank(key)) {
				key = String.format(QueryConstant.POINT_JOIN, key, fetch);
			} else {
				key = fetch;
			}

			if (!mapOfJoin.containsKey(key)) {
				from = (From<?, ?>) from.fetch(fetch, queryJoin.getJoinType());
				mapOfJoin.put(key, from);
			} else {
				from = mapOfJoin.get(key);
			}

		}

	}

}
