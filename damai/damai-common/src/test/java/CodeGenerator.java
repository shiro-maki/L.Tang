
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    @Test
    public void genCode() {

        // 1、创建代码生成器对象mpg
        AutoGenerator mpg = new AutoGenerator();

        // 2、创建全局配置对象 根据需要设置全局配置的参数
        GlobalConfig gc = new GlobalConfig();
        //获取当前系统用户所创建的当前项目的路径
        final String projectPath = System.getProperty("user.dir");
        //设置代码自动生成的文件所存储的路径地址
        gc.setOutputDir(projectPath + "/src/main/java");
        //设置项目作者的名字
        gc.setAuthor("baomidou");
        //如果为true 就会在代码生成后以资源管理器的形式自动打开所生成文件
        gc.setOpen(false); //生成后是否打开资源管理器
        //根据要求选择service包下的类名是否以I开头
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        //数据表的主键生成策略
        gc.setIdType(IdType.AUTO); //主键策略
        gc.setSwagger2(true);//开启Swagger2模式
        //将全局配置对象设置到代码生成器的对象中
        mpg.setGlobalConfig(gc);

        // 3、创建数据源配置对象
        DataSourceConfig dsc = new DataSourceConfig();
        //设置数据库的访问地址
        dsc.setUrl("jdbc:mysql://localhost:3306/cop?serverTimezone=GMT%2B8&characterEncoding=utf-8");
        //设置数据库驱动配置
        dsc.setDriverName("com.mysql.jdbc.Driver");
        //数据库的用户名
        dsc.setUsername("root");
        //数据库密码
        dsc.setPassword("root");
        //设置数据库的种类
        dsc.setDbType(DbType.MYSQL);
        // 将数据源的配置对象也加入到代码生成器对象中
        mpg.setDataSource(dsc);

        // 4、创建包配置对象
        PackageConfig pc = new PackageConfig();
        //文件的包存储路径
        pc.setParent("com.yc.damai");
        //设置实体类的包名结构 一般情况下可以直接将实体类放在pojo包下
        //pc.setEntity("pojo");
        //当然也可以放在pojo下的entity包下
//        pc.setEntity("pojo.entity"); //此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
        //我直接放在entity下
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);

        //--------------------------额外内容//
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

    //***********************

        // 5、创建策略配置对象
        StrategyConfig strategy = new StrategyConfig();
        //开启类以及接口名的驼峰命名规则
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        //开启实体类属性名的驼峰命名规则
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        //是否在数据表所对应的实体类上开启lombok (也就是加上@Data注解)
        strategy.setEntityLombokModel(true); // lombok
        //给逻辑删除字段加上逻辑删除注解@TableLogic    (1:表示已经逻辑删除 0:表示并未逻辑删除)
        //所谓的逻辑删除就是在统计表中数据的条数时 不将已经逻辑删除的数据(is_deleted字段为0的数据)计算在内
        strategy.setLogicDeleteFieldName("is_deleted");//逻辑删除字段名
        //根据阿里巴巴开发规范 对实体类的某些属性名字做了规范
        //对于数据表中的is_xxx的字段名 在转换为实体属性名的时候去掉is
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀（确保tinyint(1)）
        //启用restful api风格  在对应的controller类上加上@RestController注解
        //如果为false 则加上的是@Controller注解
        //而@RestController=@Controller+@ResponseBody
        //会使得后端返回的数据的格式是json格式

        /****额外内容*/
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("m_");
        /////////////////////


        strategy.setRestControllerStyle(true); //restful api风格控制器  返回json
        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}


