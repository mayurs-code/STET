package com.sih.stet.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ApplicationModel implements Serializable {

    public ApplicationModel() {
    }

    @SerializedName("XIIpercentage")
    private
    double xIIpercentage;
    @SerializedName("Xpercentage")
    private
    double xpercentage;
    private String aadhar;
    private String aadhar_number;
    private String address;
    private String application_no;
    private String caste;
    private String center_name;
    private String city;
    private String dob;
    private String education;
    private String email;
    private String examination_mode;
    private String father_name;
    private String first_name;
    private String gender;
    private String last_name;
    private String marks_type;
    private String mobile_number;
    private String mother_name;
    private String paper_type;
    private String password;
    private String percentage;
    private String pin;
    private String profile;
    private String religion;
    private String roll_number;
    private String sign;
    private String state;
    private String status;
    private String uid;
    private String username;
    private String fcmToken;
    private String impared;
    private String appeared;
    private String teacherCat;


    @Override
    public String toString() {
        return "ApplicationModel{ PIZZA " +
                "xIIpercentage=" + xIIpercentage +
                "\nxpercentage=" + xpercentage +
                "\naadhar='" + aadhar + '\'' +
                "\naadhar_number='" + aadhar_number + '\'' +
                "\naddress='" + address + '\'' +
                "\napplication_no='" + application_no + '\'' +
                "\ncaste='" + caste + '\'' +
                "\ncenter_name='" + center_name + '\'' +
                "\ncity='" + city + '\'' +
                "\ndob='" + dob + '\'' +
                "\neducation='" + education + '\'' +
                "\nemail='" + email + '\'' +
                "\nexamination_mode='" + examination_mode + '\'' +
                "\nfather_name='" + father_name + '\'' +
                "\nfirst_name='" + first_name + '\'' +
                "\ngender='" + gender + '\'' +
                "\nlast_name='" + last_name + '\'' +
                "\nmarks_type='" + marks_type + '\'' +
                "\nmobile_number='" + mobile_number + '\'' +
                "\nmother_name='" + mother_name + '\'' +
                "\npaper_type='" + paper_type + '\'' +
                "\npassword='" + password + '\'' +
                "\npercentage='" + percentage + '\'' +
                "\npin='" + pin + '\'' +
                "\nprofile='" + profile + '\'' +
                "\nreligion='" + religion + '\'' +
                "\nroll_number='" + roll_number + '\'' +
                "\nsign='" + sign + '\'' +
                "\nstate='" + state + '\'' +
                "\nstatus='" + status + '\'' +
                "\nuid='" + uid + '\'' +
                "\nusername='" + username + '\'' +
                "\nfcmToken='" + fcmToken + '\'' +
                "\nimpared='" + impared + '\'' +
                "\nappeared='" + appeared + '\'' +
                "\nteacherCat='" + teacherCat + '\'' +
                "\npaperLanguage='" + paperLanguage + '\'' +
                '}';
    }

    public String getPaperLanguage() {
        return paperLanguage;
    }

    public void setPaperLanguage(String paperLanguage) {
        this.paperLanguage = paperLanguage;
    }

    private String paperLanguage;

    public String getImpared() {
        return impared;
    }

    public void setImpared(String impared) {
        this.impared = impared;
    }

    public String getAppeared() {
        return appeared;
    }

    public void setAppeared(String appeared) {
        this.appeared = appeared;
    }

    public String getTeacherCat() {
        return teacherCat;
    }

    public void setTeacherCat(String teacherCat) {
        this.teacherCat = teacherCat;
    }

    public double getxIIpercentage() {
        return xIIpercentage;
    }

    public void setxIIpercentage(double xIIpercentage) {
        this.xIIpercentage = xIIpercentage;
    }

    public double getXpercentage() {
        return xpercentage;
    }

    public void setXpercentage(double xpercentage) {
        this.xpercentage = xpercentage;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getAadhar_number() {
        return aadhar_number;
    }

    public void setAadhar_number(String aadhar_number) {
        this.aadhar_number = aadhar_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApplication_no() {
        return application_no;
    }

    public void setApplication_no(String application_no) {
        this.application_no = application_no;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
    }

    public int getDob(int x) {
        String arr[] = dob.split("-");
        return Integer.parseInt(arr[x]);
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExamination_mode() {
        return examination_mode;
    }

    public void setExamination_mode(String examination_mode) {
        this.examination_mode = examination_mode;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMarks_type() {
        return marks_type;
    }

    public void setMarks_type(String marks_type) {
        this.marks_type = marks_type;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getPaper_type() {
        return paper_type;
    }

    public void setPaper_type(String paper_type) {
        this.paper_type = paper_type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public boolean checkFormalties() {
        Boolean flag = first_name.length() >= 3
                && last_name.length() >= 3
                && father_name.length() >= 3
                && mother_name.length() >= 3
                && getDob(0) <= 2000
                && getCity().length() >= 3
                && getState().length() >= 3
                && getPin().length() >= 3
                && getMobile_number().length() >= 3
                && getAadhar_number().length() >= 3;
        return flag;


    }
}
