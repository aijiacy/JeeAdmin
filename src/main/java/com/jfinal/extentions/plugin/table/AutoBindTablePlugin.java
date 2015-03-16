package com.jfinal.extentions.plugin.table;

import java.io.File;
import java.util.List;

import javax.sql.DataSource;

import com.google.common.collect.Lists;
import com.jfinal.extentions.annotation.table.TableBinding;
import com.jfinal.extentions.kit.ClazzKit;
import com.jfinal.extentions.kit.Reflect;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.IDataSourceProvider;
import com.jfinal.plugin.activerecord.Model;

public class AutoBindTablePlugin extends ActiveRecordPlugin {

    protected final Logger log = Logger.getLogger(getClass());

    @SuppressWarnings("rawtypes")
    private List<Class<? extends Model>> excludeClasses = Lists.newArrayList();
    private List<String> includeJars = Lists.newArrayList();
    private boolean autoScan = true;
    private boolean includeAllJarsInLib = false;
    private List<String> scanPackages = Lists.newArrayList();
    private INameStyle nameStyle;
    private String classpath = PathKit.getWebRootPath() + File.separator + "WEB-INF" + File.separator + "classes";
    private String libDir = PathKit.getWebRootPath() + File.separator + "WEB-INF" + File.separator + "lib";

    public AutoBindTablePlugin(IDataSourceProvider dataSourceProvider) {
        this(DbKit.MAIN_CONFIG_NAME, dataSourceProvider, SimpleNameStyles.DEFAULT);
    }

    public AutoBindTablePlugin(String configName, IDataSourceProvider dataSourceProvider) {
        this(configName, dataSourceProvider, SimpleNameStyles.DEFAULT);
    }

    public AutoBindTablePlugin(IDataSourceProvider dataSourceProvider, int transactionLevel) {
        this(DbKit.MAIN_CONFIG_NAME, dataSourceProvider, transactionLevel, SimpleNameStyles.DEFAULT);
    }

    public AutoBindTablePlugin(String configName, IDataSourceProvider dataSourceProvider, int transactionLevel) {
        this(configName, dataSourceProvider, transactionLevel, SimpleNameStyles.DEFAULT);
    }

    public AutoBindTablePlugin(IDataSourceProvider dataSourceProvider, INameStyle nameStyle) {
        super(DbKit.MAIN_CONFIG_NAME, dataSourceProvider);
        this.nameStyle = nameStyle;
    }

    public AutoBindTablePlugin(String configName, IDataSourceProvider dataSourceProvider, INameStyle nameStyle) {
        super(configName, dataSourceProvider);
        this.nameStyle = nameStyle;
    }

    public AutoBindTablePlugin(IDataSourceProvider dataSourceProvider, int transactionLevel, INameStyle nameStyle) {
        super(DbKit.MAIN_CONFIG_NAME, dataSourceProvider, transactionLevel);
        this.nameStyle = nameStyle;
    }

    public AutoBindTablePlugin(String configName, IDataSourceProvider dataSourceProvider, int transactionLevel, INameStyle nameStyle) {
        super(configName, dataSourceProvider, transactionLevel);
        this.nameStyle = nameStyle;
    }

    public AutoBindTablePlugin(DataSource dataSource) {
        this(DbKit.MAIN_CONFIG_NAME, dataSource, SimpleNameStyles.DEFAULT);
    }

    public AutoBindTablePlugin(String configName, DataSource dataSource) {
        this(configName, dataSource, SimpleNameStyles.DEFAULT);
    }

    public AutoBindTablePlugin(DataSource dataSource, int transactionLevel) {
        this(DbKit.MAIN_CONFIG_NAME, dataSource, transactionLevel, SimpleNameStyles.DEFAULT);
    }

    public AutoBindTablePlugin(String configName, DataSource dataSource, int transactionLevel) {
        this(configName, dataSource, transactionLevel, SimpleNameStyles.DEFAULT);
    }

    public AutoBindTablePlugin(DataSource dataSource, INameStyle nameStyle) {
        super(DbKit.MAIN_CONFIG_NAME, dataSource);
        this.nameStyle = nameStyle;
    }

    public AutoBindTablePlugin(String configName, DataSource dataSource, INameStyle nameStyle) {
        super(configName, dataSource);
        this.nameStyle = nameStyle;
    }

    public AutoBindTablePlugin(DataSource dataSource, int transactionLevel, INameStyle nameStyle) {
        super(DbKit.MAIN_CONFIG_NAME, dataSource, transactionLevel);
        this.nameStyle = nameStyle;
    }

    public AutoBindTablePlugin(String configName, DataSource dataSource, int transactionLevel, INameStyle nameStyle) {
        super(configName, dataSource, transactionLevel);
        this.nameStyle = nameStyle;
    }

    /**
     * 添加需要扫描的包，默认为扫描所有包
     *
     * @param packages
     * @return
     */
    public AutoBindTablePlugin addScanPackages(String... packages) {
        for (String pkg : packages) {
            scanPackages.add(pkg);
        }
        return this;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public AutoBindTablePlugin addExcludeClasses(Class<? extends Model>... clazzes) {
        for (Class<? extends Model> clazz : clazzes) {
            excludeClasses.add(clazz);
        }
        return this;
    }

    @SuppressWarnings("rawtypes")
    public AutoBindTablePlugin addExcludeClasses(List<Class<? extends Model>> clazzes) {
        if (clazzes != null) {
            excludeClasses.addAll(clazzes);
        }
        return this;
    }

    public AutoBindTablePlugin addJars(List<String> jars) {
        if (jars != null) {
            includeJars.addAll(jars);
        }
        return this;
    }

    public AutoBindTablePlugin addJars(String... jars) {
        if (jars != null) {
            for (String jar : jars) {
                includeJars.add(jar);
            }
        }
        return this;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public boolean start() {
        List<Class<? extends Model>> modelClasses = ClazzKit.of(Model.class).libDir(libDir).classpath(classpath)
                .scanPackages(scanPackages).injars(includeJars).includeAllJarsInLib(includeAllJarsInLib).search();
        TableBinding tb;
        for (Class modelClass : modelClasses) {
            if (excludeClasses.contains(modelClass)) {
                continue;
            }
            tb = (TableBinding) modelClass.getAnnotation(TableBinding.class);
            String tableName;
            String arpConfName = Reflect.on(this).get("configName");
            if (tb == null) {
                if (!autoScan) {
                    continue;
                }
                tableName = nameStyle.name(modelClass.getSimpleName());
                this.addMapping(tableName, modelClass);
                log.debug(arpConfName + " addMapping(" + tableName + ", " + modelClass.getName() + ")");
            } else {
                String tbConfName = tb.configName();
                if (StrKit.notBlank(tbConfName) && !tbConfName.equals(arpConfName)) continue;
                tableName = tb.tableName();
                if (StrKit.notBlank(tb.pkName())) {
                    this.addMapping(tableName, tb.pkName(), modelClass);
                    log.debug(arpConfName + " addMapping(" + tableName + ", " + tb.pkName() + "," + modelClass.getName() + ")");
                } else {
                    this.addMapping(tableName, modelClass);
                    log.debug(arpConfName + " addMapping(" + tableName + ", " + modelClass.getName() + ")");
                }
            }
        }
        return super.start();
    }

    @Override
    public boolean stop() {
        return super.stop();
    }

    public AutoBindTablePlugin autoScan(boolean autoScan) {
        this.autoScan = autoScan;
        return this;
    }

    public AutoBindTablePlugin classpath(String classpath) {
        this.classpath = classpath;
        return this;
    }

    public AutoBindTablePlugin libDir(String libDir) {
        this.libDir = libDir;
        return this;
    }
    public AutoBindTablePlugin includeAllJarsInLib(boolean includeAllJarsInLib) {
        this.includeAllJarsInLib = includeAllJarsInLib;
        return this;
    }
}
