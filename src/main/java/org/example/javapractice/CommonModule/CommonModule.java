package org.example.javapractice.CommonModule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommonModule {

    public CommonModule() {

    };

    public List<String> getPackageNameFromPackage(String source, boolean isClass)
    {

        List<String> list = new ArrayList<>();
        File directory = new File(source);

        if (directory.exists())
        {
            File[] files = directory.listFiles();
            if (files != null)
            {
                for (File file : files)
                {
                    if (!isClass && file.isDirectory())
                    {
                        list.add(file.getName());
                    }

                    else if (isClass && file.isFile())
                    {
                        list.add(file.getName().substring(0, file.getName().length() - 5));
                    }
                }
            }
        }

        return list;
    }

}
