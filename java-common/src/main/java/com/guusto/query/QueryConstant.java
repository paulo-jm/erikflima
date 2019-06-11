package com.guusto.query;

public class QueryConstant {
	
	private QueryConstant() {
		throw new UnsupportedOperationException();
	}

	public static final String POINT_REGEX = "\\.";

	public static final String POINT_DELIMITER = ".";

	public static final String POINT_JOIN = "%s.%s";

	public static final String EMPTY_SPACE_REGEX = "\\s+";

	public static final String ORDER_SORT_ASC = "ASC";

	public static final String ORDER_SORT_DESC = "DESC";

	public static final Long MAX_LIMIT = Long.valueOf(10);

}
