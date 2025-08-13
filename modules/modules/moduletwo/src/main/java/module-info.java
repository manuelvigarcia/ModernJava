module moduletwo {
    /* requires moduleone; //using "transitive so modulethree can access moduleone through this moduletwo. */
    requires transitive moduleone;

    exports com.moduletwo.dtos;
    exports com.moduletwo.service;
}