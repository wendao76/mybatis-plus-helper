package com.github.wendao76.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis plus 代码生成器
 *
 * @author wendao76
 * @version 1.0
 * @description mybatis plus 代码生成器
 * @className CodeBuilder
 * @date 2020-6-5 15:29
 */
public class MybatisPlusGenerator {
  public static void main(String[] args) {
    // 参数声明
    // 1. 输出目录
    String outputDir = "E://JavaTemp";
    // 2. 包前缀
    String basePackage = "com.bosssoft.wx";
    // 3. 模块前缀
    String moduleName = "common";
    // 4. 表列表
    String[] tables = new String[] {"evaluate_summary"};

    AutoGenerator mpg = new AutoGenerator();
    // 全局配置
    mpg.setGlobalConfig(genGlobalConfig(outputDir));
    // 数据源
    mpg.setDataSource(genDataSourceConfig());
    // 策略配置
    mpg.setStrategy(genStrategyConfig(tables));
    // 包配置
    mpg.setPackageInfo(genPackageConfig(basePackage, moduleName));
    // 关闭默认 xml
    mpg.setTemplate(genTemplateConfig());
    // 执行生成
    mpg.execute();
  }

  /**
   * 全局配置生成
   *
   * @param outputDir
   * @return
   */
  static GlobalConfig genGlobalConfig(String outputDir) {
    GlobalConfig gc = new GlobalConfig();
    gc.setOutputDir(outputDir);
    gc.setFileOverride(true);
    gc.setActiveRecord(true);
    gc.setEnableCache(false);
    gc.setBaseColumnList(true);
    gc.setAuthor("wendao76");
    // 自定义文件命名，注意 %s 会自动填充表实体属性！
    gc.setMapperName("%sMapper");
    gc.setXmlName("%sMapper");
    gc.setServiceName("%sService");
    gc.setServiceImplName("%sServiceImpl");
    gc.setControllerName("%sController");
    return gc;
  }

  /**
   * 数据源配置生成
   *
   * @return
   */
  static DataSourceConfig genDataSourceConfig() {
    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("root");
    dsc.setUrl("jdbc:mysql://127.0.0.1:3306/big_white?characterEncoding=utf8&serverTimezone=GMT");
    return dsc;
  }

  /**
   * 策略配置生成
   *
   * @return
   */
  static StrategyConfig genStrategyConfig(String[] tables) {
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel); // 表名生成策略
    strategy.setInclude(tables); // 需要生成的表
    // strategy.setExclude(new String[]{"test"}); // 排除生成的表
    // 自定义实体父类
    //    strategy.setSuperEntityClass();
    // 自定义实体，公共字段
    strategy.setSuperEntityColumns(new String[] {"create_time", "modify_time"});
    strategy.setEntityLombokModel(true);
    // 自定义 mapper 父类
    // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
    // 自定义 service 父类
    // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
    // 自定义 service 实现类父类
    // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
    // 自定义 controller 父类
    // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
    // 【实体】是否生成字段常量（默认 false）
    // public static final String ID = "test_id";
    // strategy.setEntityColumnConstant(true);
    // 【实体】是否为构建者模型（默认 false）
    // public User setName(String name) {this.name = name; return this;}
    // strategy.setEntityBuilderModel(true);
    return strategy;
  }

  /**
   * 包配置生成
   *
   * @param baseName
   * @param moduleName 模块名称
   * @return
   */
  static PackageConfig genPackageConfig(String baseName, String moduleName) {
    PackageConfig pc = new PackageConfig();
    pc.setParent(baseName);
    pc.setController(concat("controller", moduleName));
    pc.setService("service");
    pc.setEntity(concat("service", moduleName, "entity"));
    pc.setServiceImpl(concat("service", moduleName, "impl"));
    pc.setMapper(concat("service", moduleName, "mapper"));
    pc.setXml(concat("service", moduleName, "mapper.xml"));
    return pc;
  }

  static String concat(String... str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length; i++) {
      sb.append(str[i]).append(".");
    }
    int len = sb.length() - 1;
    System.out.println(sb.toString());
    return sb.toString().substring(0, len);
  }

  /**
   * 生成模板配置
   *
   * @return
   */
  static TemplateConfig genTemplateConfig() {
    return new TemplateConfig();
  }
}
