package com.revature.application.dao.implementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.application.dao.LocationDao;
import com.revature.application.dao.beans.Location;

@Service
public class LocationDaoImpl implements LocationDao {
	
	@Autowired
	SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	@Transactional
	public boolean create(Location loc) {
		
		Session session = sf.getCurrentSession();
		
		session.save(loc);
		session.flush();
		 
		return true;
	}

	@Override
	@Transactional
	public Location read(long loc_id) {
		
		Session session = sf.getCurrentSession();
		Location loc = session.get(Location.class, loc_id);
		session.flush();

		return loc;
	}

	@Override
	@Transactional
	public List<Location> readAll() {
		
		Session session = sf.getCurrentSession();
		
		List<Location> locations = session.createQuery("from Location location").list();
		session.flush();
		
		return locations;
	}

	@Override
	@Transactional
	public boolean update(Location loc) {
		
		Session session = sf.getCurrentSession();
		
		session.update(loc);
		session.flush();
			
		return true;
	}

	@Override
	@Transactional
	public boolean delete(Location loc) {
		
		Session session = sf.getCurrentSession();

		session.delete(loc);
		session.flush();
		
		return true;
	}

	@Override
	@Transactional
	public boolean deleteById(long loc_id) {
		
		Session session = sf.getCurrentSession();

		Location loc = new Location();
		loc.setLocationId(loc_id);
		session.delete(loc);
		
		session.flush();
		
		return true;
	}

}
