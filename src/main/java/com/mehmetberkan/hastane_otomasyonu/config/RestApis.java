package com.mehmetberkan.hastane_otomasyonu.config;

public class RestApis {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String BASE_URL = DEV + VERSION;

    public static final String USER = BASE_URL+"/user";
    public static final String RANDEVU = BASE_URL+"/randevu";;
    public static final String DOKTOR = BASE_URL+"/doktor";

    public static final String DOREGISTER = "/register";
    public static final String LOGIN = "/login";

    public static final String ADD_ROLE = "/add-role";

    public static final String CANCEL_RANDEVU = "/cancel-randevu";
    public static final String ADD_RANDEVU= "/add-randevu";
    public static final String FIND_RANDEVU = "/find-randevu";

    public static final String ADD_DOKTOR = "/add-doktor";
    public static final String FIND_DOKTOR= "/find-doktor";
    public static final String GET_ALL_DOKTOR= "/get-all-doktor";
    public static final String FIND_BY_DOKTOR_BRANS = "/find-by-doktor-brans";
}
