package com.example.demo.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 不能用插件
 * 因为自定义注释的classpath 不同
 */
public class MybatisGeneratorStartup {
    public static void main(String[] args) {

        try {
            List<String> warnings = new ArrayList<>();
            boolean overwrite = true;
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream is = new FileInputStream("src/main/resources/generator/generatorConfig.xml");
            ConfigurationParser parser = new ConfigurationParser(warnings);
            Configuration config = parser.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}