package com.example.user.roomandroid.room.converters;

import android.arch.persistence.room.TypeConverter;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User on 23.08.2018.
 */

public class SkillsConverter {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @TypeConverter
    public String fromSkills(List<String> skills){
        return skills.stream().collect(Collectors.joining(","));
    }

    @TypeConverter
    public List<String> toSkills(String data){
        return Arrays.asList(data.split(","));
    }
}
