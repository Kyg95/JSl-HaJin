package yyg;

import java.io.InputStream;

import javax.annotation.Resources;

public class CRUDprocess {
	// �� Ŭ������ ���� : MyBatis�� ���۸� ȣ���Ѵ�.
	// �������� �ϳ�? 1. mybatisȯ�漳���� �д´�
	// 2.���� 1�� �۾����� ���۸� ȣ���� ��ü(sqlSession)�� �����Ѵ�.
	// Ư�̻��� : sqlSession�� sqlSessionFactory�� �����Ѵ�.
	// sqlSessionFactory�� sqlSessionFactoryBuiler�� �����Ѵ�.
	/////// sqlSession�� ����� �޼���/////////////////
	private SqlSession getSession() {// �ٸ� ��ü���� ����ȵǴϱ� private�� ����
		String path = "yyg/mybatis_config.xml";// ���� ����ּ� �߰��������
		InputStream/* � ������ �д��Ŀ� ���� �޶��� */ is = null;// ������ ������ ���� ��ü
		try {
			is = Resources.getResourceAsStream(path);
		} catch (Exception e) {
			System.out.println("ȯ�漳�� ���� �߻�");
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // ������ ������ ���丮�� ��������
		SqlSessionFactory factory = builder.build(is); // ���丮����� ���������� �θ�
		SqlSession session = factory.openSession(); // ���丮 �����ڿ���
		return session;
	}

	public Customer_info selectCustomer(String id) {
		SqlSession s = getSession();
		Customer_info cust;
		try {
			cust = s.selectOne("loginmapper.selectCustomer", id);
			return cust;
		} finally {
			s.close();
		}
	}

	public int insertCustomer(Customer_info customer) {
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.insert("loginmapper.insertCustomer", customer);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}
	}
	
	public insertCustomer selectIdAndPwd(UserIdPwd uip) { // �ٸ������� ����ؾ��ϱ⋚���� public �� ���
		SqlSession s = getSession();
		try {
			insertCustomer info = s.selectOne("loginmapper.selectIdPwd", uip); // ������ ���� �̸��� ��
			// selectone�� �˻������ 1���� ���� ����ϴ� �޼���
			// selectList�� �˻������ �����ǿ� ����ϴ� �޼���
			return info;
		} finally { // ���ܰ� �߻��ϴ� �����ʴ� ������ ������
			s.close();// �Ϸ�ɰ�� �ݴ´�

		} // DB�� manager_info ���̺��� id�� ��ȣ�� ã�Ƽ� ����
	}
	

	// db�ۼ����� mapper�ۼ� crud�ҽ� �ۼ�

}
// ���� ��Ʈ��ũ,db����,������
// �ݵ�� "����ó��"�� �ؾ��Ѵ�. try {����ó�� ���α׷�, ��Ʈ��ũ���α׷� ,������} catch(exception A ��ΰ� ����ϴ°���
// ��,������){"�ȳ��޼������"}
// �ڹٿ��� �߻��ϴ� ������ ��ü��