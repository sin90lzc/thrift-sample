/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dtc.sample.thrift.service;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-04-27")
public class SimpleBean implements org.apache.thrift.TBase<SimpleBean, SimpleBean._Fields>, java.io.Serializable, Cloneable, Comparable<SimpleBean> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SimpleBean");

  private static final org.apache.thrift.protocol.TField COMPLEX_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("complexType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SIMPLE_BEAN_FIELD_DESC = new org.apache.thrift.protocol.TField("simpleBean", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SimpleBeanStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SimpleBeanTupleSchemeFactory());
  }

  /**
   * 
   * @see ComplexType
   */
  public ComplexType complexType; // required
  public int id; // required
  public SimpleBean simpleBean; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see ComplexType
     */
    COMPLEX_TYPE((short)1, "complexType"),
    ID((short)2, "id"),
    SIMPLE_BEAN((short)3, "simpleBean");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // COMPLEX_TYPE
          return COMPLEX_TYPE;
        case 2: // ID
          return ID;
        case 3: // SIMPLE_BEAN
          return SIMPLE_BEAN;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COMPLEX_TYPE, new org.apache.thrift.meta_data.FieldMetaData("complexType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ComplexType.class)));
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SIMPLE_BEAN, new org.apache.thrift.meta_data.FieldMetaData("simpleBean", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "SimpleBean")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SimpleBean.class, metaDataMap);
  }

  public SimpleBean() {
  }

  public SimpleBean(
    ComplexType complexType,
    int id,
    SimpleBean simpleBean)
  {
    this();
    this.complexType = complexType;
    this.id = id;
    setIdIsSet(true);
    this.simpleBean = simpleBean;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SimpleBean(SimpleBean other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetComplexType()) {
      this.complexType = other.complexType;
    }
    this.id = other.id;
    if (other.isSetSimpleBean()) {
      this.simpleBean = other.simpleBean;
    }
  }

  public SimpleBean deepCopy() {
    return new SimpleBean(this);
  }

  @Override
  public void clear() {
    this.complexType = null;
    setIdIsSet(false);
    this.id = 0;
    this.simpleBean = null;
  }

  /**
   * 
   * @see ComplexType
   */
  public ComplexType getComplexType() {
    return this.complexType;
  }

  /**
   * 
   * @see ComplexType
   */
  public SimpleBean setComplexType(ComplexType complexType) {
    this.complexType = complexType;
    return this;
  }

  public void unsetComplexType() {
    this.complexType = null;
  }

  /** Returns true if field complexType is set (has been assigned a value) and false otherwise */
  public boolean isSetComplexType() {
    return this.complexType != null;
  }

  public void setComplexTypeIsSet(boolean value) {
    if (!value) {
      this.complexType = null;
    }
  }

  public int getId() {
    return this.id;
  }

  public SimpleBean setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public SimpleBean getSimpleBean() {
    return this.simpleBean;
  }

  public SimpleBean setSimpleBean(SimpleBean simpleBean) {
    this.simpleBean = simpleBean;
    return this;
  }

  public void unsetSimpleBean() {
    this.simpleBean = null;
  }

  /** Returns true if field simpleBean is set (has been assigned a value) and false otherwise */
  public boolean isSetSimpleBean() {
    return this.simpleBean != null;
  }

  public void setSimpleBeanIsSet(boolean value) {
    if (!value) {
      this.simpleBean = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COMPLEX_TYPE:
      if (value == null) {
        unsetComplexType();
      } else {
        setComplexType((ComplexType)value);
      }
      break;

    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case SIMPLE_BEAN:
      if (value == null) {
        unsetSimpleBean();
      } else {
        setSimpleBean((SimpleBean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COMPLEX_TYPE:
      return getComplexType();

    case ID:
      return getId();

    case SIMPLE_BEAN:
      return getSimpleBean();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COMPLEX_TYPE:
      return isSetComplexType();
    case ID:
      return isSetId();
    case SIMPLE_BEAN:
      return isSetSimpleBean();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SimpleBean)
      return this.equals((SimpleBean)that);
    return false;
  }

  public boolean equals(SimpleBean that) {
    if (that == null)
      return false;

    boolean this_present_complexType = true && this.isSetComplexType();
    boolean that_present_complexType = true && that.isSetComplexType();
    if (this_present_complexType || that_present_complexType) {
      if (!(this_present_complexType && that_present_complexType))
        return false;
      if (!this.complexType.equals(that.complexType))
        return false;
    }

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_simpleBean = true && this.isSetSimpleBean();
    boolean that_present_simpleBean = true && that.isSetSimpleBean();
    if (this_present_simpleBean || that_present_simpleBean) {
      if (!(this_present_simpleBean && that_present_simpleBean))
        return false;
      if (!this.simpleBean.equals(that.simpleBean))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_complexType = true && (isSetComplexType());
    list.add(present_complexType);
    if (present_complexType)
      list.add(complexType.getValue());

    boolean present_id = true;
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_simpleBean = true && (isSetSimpleBean());
    list.add(present_simpleBean);
    if (present_simpleBean)
      list.add(simpleBean);

    return list.hashCode();
  }

  @Override
  public int compareTo(SimpleBean other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetComplexType()).compareTo(other.isSetComplexType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetComplexType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.complexType, other.complexType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSimpleBean()).compareTo(other.isSetSimpleBean());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSimpleBean()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.simpleBean, other.simpleBean);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SimpleBean(");
    boolean first = true;

    sb.append("complexType:");
    if (this.complexType == null) {
      sb.append("null");
    } else {
      sb.append(this.complexType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("simpleBean:");
    if (this.simpleBean == null) {
      sb.append("null");
    } else {
      sb.append(this.simpleBean);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SimpleBeanStandardSchemeFactory implements SchemeFactory {
    public SimpleBeanStandardScheme getScheme() {
      return new SimpleBeanStandardScheme();
    }
  }

  private static class SimpleBeanStandardScheme extends StandardScheme<SimpleBean> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SimpleBean struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COMPLEX_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.complexType = com.dtc.sample.thrift.service.ComplexType.findByValue(iprot.readI32());
              struct.setComplexTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SIMPLE_BEAN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.simpleBean = new SimpleBean();
              struct.simpleBean.read(iprot);
              struct.setSimpleBeanIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SimpleBean struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.complexType != null) {
        oprot.writeFieldBegin(COMPLEX_TYPE_FIELD_DESC);
        oprot.writeI32(struct.complexType.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      if (struct.simpleBean != null) {
        oprot.writeFieldBegin(SIMPLE_BEAN_FIELD_DESC);
        struct.simpleBean.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SimpleBeanTupleSchemeFactory implements SchemeFactory {
    public SimpleBeanTupleScheme getScheme() {
      return new SimpleBeanTupleScheme();
    }
  }

  private static class SimpleBeanTupleScheme extends TupleScheme<SimpleBean> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SimpleBean struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetComplexType()) {
        optionals.set(0);
      }
      if (struct.isSetId()) {
        optionals.set(1);
      }
      if (struct.isSetSimpleBean()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetComplexType()) {
        oprot.writeI32(struct.complexType.getValue());
      }
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetSimpleBean()) {
        struct.simpleBean.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SimpleBean struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.complexType = com.dtc.sample.thrift.service.ComplexType.findByValue(iprot.readI32());
        struct.setComplexTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.simpleBean = new SimpleBean();
        struct.simpleBean.read(iprot);
        struct.setSimpleBeanIsSet(true);
      }
    }
  }

}

