package store.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import store.domain.IpRecord;
import store.utils.DataSourceUtils;

public class IpRecordDao {
	   // 添加操作记录
		public void insertIpRecord(IpRecord ip_record) throws SQLException {
			String sql = "insert into `iprecord`(`user_id`,`role`,`ip`,`opType`) values(?,?,?,?);";
			QueryRunner runner = new QueryRunner();
			runner.update(DataSourceUtils.getConnection(), sql, ip_record.getUser_id(),
					ip_record.getRole(), ip_record.getIp(), ip_record.getOpType());
		}
		
		   /*// 更新操作记录(废弃)
			public void updateIpRecord(IpRecord ip_record) throws SQLException {
				String sql ="update  `iprecord` set  `ip` =? where user_id=?;";
				QueryRunner runner = new QueryRunner();
				runner.update(DataSourceUtils.getConnection(), sql, ip_record.getIp(),
						ip_record.getUser_id());
			}*/
		
		// 获取所有操作记录
		public List<IpRecord> getIpAllRecord() throws SQLException {
			String sql = "select * from `iprecord` order by opTime desc;";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<IpRecord>(IpRecord.class));
		}
		
		//获取特定用户操作记录
		public IpRecord getIpRecord(int user_id) throws SQLException {
			String sql = "select * from `iprecord` where user_id=?;";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanHandler<IpRecord>(IpRecord.class), user_id);
		}
}
