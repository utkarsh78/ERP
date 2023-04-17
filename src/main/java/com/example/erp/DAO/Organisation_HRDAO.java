package com.example.erp.DAO;

import com.example.erp.Bean.Organisation;
import com.example.erp.Bean.Organisation_HR;

import java.util.List;

public interface Organisation_HRDAO {

    boolean addOrganisation_hr(Organisation_HR org_hr);


    boolean deletehr(int orghr_id);

    List<Organisation_HR> viewDetails(Organisation_HR s);

    boolean updateDetails(Organisation_HR orghr);

    Organisation_HR getHRByID(int orghrID);

    List<Organisation_HR> getOrganisation_HRList();
}
