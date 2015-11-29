package gz.vin.nammu.core.service;

import java.util.List;

public class QueryWrapper<E,F> {
	private List<IDataFilter<E>> filter;
	private List<IDataPath<F>> paths;
	private List<?> resultList;
	private int firstResult;
	private int limit;
		
	public QueryWrapper() {
		firstResult = 1;
		limit = 20;
	}
	
	public QueryWrapper(List<IDataFilter<E>> filter, List<IDataPath<F>> paths) {
		this.filter = filter;
		this.paths = paths;
	}
	
	public List<IDataFilter<E>> getFilter() {
		return filter;
	}
	
	public void setFilter(List<IDataFilter<E>> filter) {
		this.filter = filter;
	}
	
	public List<IDataPath<F>> getPaths() {
		return paths;
	}
	
	public void setPaths(List<IDataPath<F>> paths) {
		this.paths = paths;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
