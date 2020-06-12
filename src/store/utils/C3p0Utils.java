package store.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*���ڴ�������Դ,,Ĭ�϶�ȡc3p0-config.xml��������*/
public class C3p0Utils {

	private static DataSource ds;
	static {
		ds = new ComboPooledDataSource();
	}
	public static DataSource getDataSource() {
		return ds;
	}
}
