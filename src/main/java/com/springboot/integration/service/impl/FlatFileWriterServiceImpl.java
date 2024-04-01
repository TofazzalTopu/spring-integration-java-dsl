package com.springboot.integration.service.impl;

import com.springboot.integration.model.fileWriter.Detail;
import com.springboot.integration.model.fileWriter.FileWriter;
import com.springboot.integration.model.fileWriter.Header;
import com.springboot.integration.model.fileWriter.Trailer;
import com.springboot.integration.service.fileWriter.FlatFileWriterService;
import org.beanio.BeanIOConfigurationException;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FlatFileWriterServiceImpl implements FlatFileWriterService {

    private Header header = new Header("H", "FLAT_FILE");
    private Trailer trailer = new Trailer("T", "FLAT_FILE");
    private List<Detail> details = new ArrayList<>(Arrays.asList(
            new Detail("6813162459", "RM2.00"),
            new Detail("2039229524", "RM10.00"),
            new Detail("2299488320", "RM5.00")));

    @Override
    public void write() throws Exception {
        StreamFactory factory = StreamFactory.newInstance();

        File file = ResourceUtils.getFile("classpath:flatfile.xml");
        factory.load(file.getAbsolutePath());

        FileWriter fileWriter = new FileWriter(header, details, trailer);

        try (BeanWriter out = factory.createWriter("fileWriters", new File("flatFile.csv"))) {
            out.write(fileWriter);
            out.flush();
        }
    }

}
