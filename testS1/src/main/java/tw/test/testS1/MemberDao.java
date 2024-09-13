package tw.test.testS1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MemberDao {
	
	public void addMember(Member member) {
				
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction transaction = session.beginTransaction();
			
			session.persist(member);
			
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Member getMemberById(int id) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Member member = session.get(Member.class,id);
			return member;
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public void deleteMember(Member member) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction transaction = session.beginTransaction();
			
			session.remove(member);
			
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void updateMember(Member member) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction transaction = session.beginTransaction();
			
			session.merge(member);
			
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public List<Member> getAll() throws Exception{
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			String hql = "from Member";
			
			Query<Member> query = session.createQuery(hql,Member.class);
			
			return query.getResultList();
			
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception();
		}
		
	}
	
	public List<Member> getByWhere(String hql) throws Exception{
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			Query<Member> query = session.createQuery(hql,Member.class);
			
			return query.getResultList();
			
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception();
		}
		
	}
	
}
