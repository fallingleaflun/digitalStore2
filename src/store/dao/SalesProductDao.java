package store.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import store.domain.IpRecord;
import store.domain.SalesProduct;
import store.utils.DataSourceUtils;

public class SalesProductDao {
	 // 添加销售和商品
	public void insertSalesProduct(SalesProduct salesProduct) throws SQLException {
		String sql = "insert into `sales_product`(`user_id`, `procuct_id`) values(?,?);";
		QueryRunner runner = new QueryRunner();
		runner.update(DataSourceUtils.getConnection(), sql, salesProduct.getUser_id(),
				salesProduct.getProcuct_id());
	}
}
