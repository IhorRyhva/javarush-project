package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    private int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if(versionHistoryMap.containsKey(rollbackVersion)){
            currentVersion = rollbackVersion;
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int map : versionHistoryMap.keySet()) {
                if(map > rollbackVersion) {
                    arrayList.add(map);
                }
            }
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                versionHistoryMap.remove(arrayList.get(i));
            }
            return true;
        }
        return false;
    }
}
