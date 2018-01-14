package com.lybj.util.bean;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;


/**
 * Created by Administrator on 2018/1/14.
 */
public class BeanUtilsTest {



    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void beanToMap() throws Exception {
        SuperComputer superComputer = new SuperComputer();
        Brand brand = new Brand();
        brand.setName("Sequoia"); //红杉
        superComputer.setBrand(brand);
        superComputer.setPrice(100000l);
        superComputer.setBulk(20000l);
        superComputer.setCpu("Intel 123");
        superComputer.setMemory("DDR 3");
        superComputer.setInputDevices("输入设备");
        superComputer.setOutputDevices("输出设备");
        //target
        HashMap<Object, Object> map = new HashMap<>();
        map.put("price", 100000l);
        map.put("bulk", 20000l);
        map.put("cpu", "Intel 123");
        map.put("memory", "DDR 3");
        map.put("inputDevices", "输入设备");
        map.put("outputDevices", "输出设备");
        map.put("brand", brand);

        Assert.assertEquals(map, BeanUtils.beanToMap(superComputer));


    }

    @Test
    public void mapToBean() throws Exception {
        Brand brand = new Brand();
        brand.setName("Sequoia"); //红杉
        HashMap<Object, Object> map = new HashMap<>();
        map.put("price", 100000l);
        map.put("bulk", 20000l);
        map.put("cpu", "Intel 123");
        map.put("memory", "DDR 3");
        map.put("inputDevices", "输入设备");
        map.put("outputDevices", "输出设备");
        map.put("brand", brand);
        //target
        SuperComputer superComputer = new SuperComputer();
        superComputer.setBrand(brand);
        superComputer.setPrice(100000l);
        superComputer.setBulk(20000l);
        superComputer.setCpu("Intel 123");
        superComputer.setMemory("DDR 3");
        superComputer.setInputDevices("输入设备");
        superComputer.setOutputDevices("输出设备");
        Assert.assertEquals(superComputer, BeanUtils.mapToBean(SuperComputer.class, map));
    }



}

//内部类无法反射
class Brand{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {return Objects.hash(name);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        final Brand other = (Brand) obj;
        return Objects.equals(this.name, other.name);
    }
}


 class Computer{
    protected String cpu;
    protected String memory;
    protected String inputDevices;
    protected String outputDevices;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getInputDevices() {
        return inputDevices;
    }

    public void setInputDevices(String inputDevices) {
        this.inputDevices = inputDevices;
    }

    public String getOutputDevices() {
        return outputDevices;
    }

    public void setOutputDevices(String outputDevices) {
        this.outputDevices = outputDevices;
    }

    @Override
    public int hashCode() {return Objects.hash(cpu, memory, inputDevices, outputDevices);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        final Computer other = (Computer) obj;
        return Objects.equals(this.cpu, other.cpu)
                && Objects.equals(this.memory, other.memory)
                && Objects.equals(this.inputDevices, other.inputDevices)
                && Objects.equals(this.outputDevices, other.outputDevices);
    }
}

  class SuperComputer extends Computer{
    private Long price;
    private Long bulk;
    private Brand brand;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getBulk() {
        return bulk;
    }

    public void setBulk(Long bulk) {
        this.bulk = bulk;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    } @Override
      public int hashCode() {return super.hashCode() + Objects.hash(price, bulk, brand, cpu, memory, inputDevices, outputDevices);}

      @Override
      public boolean equals(Object obj) {
          if (this == obj) {return true;}
          if (obj == null || getClass() != obj.getClass()) {return false;}
          final SuperComputer other = (SuperComputer) obj;
          return Objects.equals(this.price, other.price)
                  && Objects.equals(this.bulk, other.bulk)
                  && Objects.equals(this.brand, other.brand)
                  && Objects.equals(this.cpu, other.cpu)
                  && Objects.equals(this.memory, other.memory)
                  && Objects.equals(this.inputDevices, other.inputDevices)
                  && Objects.equals(this.outputDevices, other.outputDevices);
      }
  }

