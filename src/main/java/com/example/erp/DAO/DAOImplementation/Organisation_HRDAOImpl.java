package com.example.erp.DAO.DAOImplementation;

import com.example.erp.Bean.Organisation;
import com.example.erp.Bean.Organisation_HR;
import com.example.erp.DAO.Organisation_HRDAO;
import com.example.erp.Util.HibernateSessionUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Organisation_HRDAOImpl implements Organisation_HRDAO {

    @Override
    public boolean addOrganisation_hr(Organisation_HR orghrObj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(orghrObj);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }


    @Override
    public boolean deletehr(int orghr_id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            List<Organisation_HR> list = new ArrayList<>(
                    session.createQuery("from Organisation_HR where organisationHRID= :orghr_id")
                            .setParameter("orghr_id",orghr_id).list()
            );

            session.delete(list.get(0));
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Organisation_HR> viewDetails(Organisation_HR s) {
        List<Organisation_HR> hrList = new ArrayList<>();
        Session session = HibernateSessionUtil.getSession();
        try {
            for (final Object spec : session.createQuery("from Organisation_HR ").list()) {
                hrList.add((Organisation_HR) spec);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return hrList;

    }

    @Override
    public boolean updateDetails(Organisation_HR org) {
        try (Session session = HibernateSessionUtil.getSession()) {

            Transaction transaction = session.beginTransaction();

            List<Organisation_HR> list = new ArrayList<>(
                    session.createQuery("from Organisation_HR  where organisationHRID =:org")
                            .setParameter("org",org.getOrganisationHRID()).list()
            );
            list.get(0).setOrganisationhr_first_name(org.getOrganisationhr_first_name());
            list.get(0).setOrganisationhr_last_name(org.getOrganisationhr_last_name());
            list.get(0).setOrganisationhr_contact_no(org.getOrganisationhr_contact_no());
            list.get(0).setOrganisationhr_email(org.getOrganisationhr_email());
            list.get(0).setOrganisationIndex(org.getOrganisationIndex());
            session.update(list.get(0));
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }


    @Override
    public Organisation_HR getHRByID(int orghrID) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Organisation_HR.class, orghrID);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Organisation_HR> getOrganisation_HRList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Organisation_HR> HRList = new ArrayList<>();
            for (final Object o : session.createQuery("from Organisation_HR").list()) {
                HRList.add((Organisation_HR) o);
            }
            return HRList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

}
