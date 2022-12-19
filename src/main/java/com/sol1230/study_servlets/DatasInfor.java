package com.sol1230.study_servlets;

import com.sol1230.study_servlets.beans.MemberBean;
import java.util.ArrayList;
import java.util.HashMap;

public class DatasInfor {

  public HashMap<String, String> getSearchFormData() {
    HashMap<String, String> searchForm = new HashMap<String, String>();
    searchForm.put("search_key", "Search Title");
    searchForm.put("name", "은솔!");
    searchForm.put("id", "ID0001");
    return searchForm;
  }

  public ArrayList<String> getTablesListWithString() {
    ArrayList<String> tablesListWithString = new ArrayList<String>();
    tablesListWithString.add("@mdo");
    tablesListWithString.add("@fat");
    tablesListWithString.add("@twitter");
    return tablesListWithString;
  }

  public HashMap<String, Object> getBundlesData() {
    DatasInfor datasInfor = new DatasInfor();
    HashMap<String, String> searchForm = datasInfor.getSearchFormData();
    ArrayList<String> tablesListWithString = datasInfor.getTablesListWithString();

    HashMap<String, Object> bundlesData = new HashMap<>();
    bundlesData.put("searchForm", searchForm);
    bundlesData.put("tablesListWithString", tablesListWithString);

    bundlesData.put("dataWithMamberBean", datasInfor.getDataWithMamberBean());
    bundlesData.put(
      "dataListWithMemberBean",
      datasInfor.getDataListWithMemberBean()
    );

    return bundlesData;
  }

  public MemberBean getDataWithMamberBean() {
    MemberBean memberBean = new MemberBean();
    memberBean.setFirstName("Mark");
    memberBean.setSecondName("Otto");
    memberBean.setHandleName("@mdo");

    return memberBean;
  }

  public ArrayList<MemberBean> getDataListWithMemberBean() {
    ArrayList<MemberBean> membersList = new ArrayList<>();
    MemberBean memberBean = new MemberBean();
    memberBean.setFirstName("Mark");
    memberBean.setSecondName("Otto");
    memberBean.setHandleName("@mdo");
    membersList.add(memberBean);

    MemberBean memberBean02 = new MemberBean();
    memberBean02.setFirstName("Jacob");
    memberBean02.setSecondName("Thornton");
    memberBean02.setHandleName("@fat");
    membersList.add(memberBean02);

    MemberBean memberBean03 = new MemberBean();
    memberBean03.setFirstName("Larry");
    memberBean03.setSecondName("Bird");
    memberBean03.setHandleName("@twitter");
    membersList.add(memberBean03);
    return membersList;
  }
}
