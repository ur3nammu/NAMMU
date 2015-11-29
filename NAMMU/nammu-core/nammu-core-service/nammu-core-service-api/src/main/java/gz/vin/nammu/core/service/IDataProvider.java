package gz.vin.nammu.core.service;

import java.util.List;

public interface IDataProvider<E,F> {
	
	void countSearch(List<IDataFilter<E>> filters);

	QueryWrapper<E,F> search(QueryWrapper<E,F> queryWrapper);
}
