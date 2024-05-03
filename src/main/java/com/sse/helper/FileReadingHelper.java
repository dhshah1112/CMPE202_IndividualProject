package com.sse.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingHelper {

    public String extractFileContent(String filePath)
    {
        StringBuffer fileContentBuffer = new StringBuffer();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;

            while ((line= br.readLine())!=null)
            {
                fileContentBuffer.append(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e)
        {

        }

        return fileContentBuffer.toString();
    }

}
