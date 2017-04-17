// ORM class for table 'data'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Mon Apr 10 20:43:25 CST 2017
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class data extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String probe_id;
  public String get_probe_id() {
    return probe_id;
  }
  public void set_probe_id(String probe_id) {
    this.probe_id = probe_id;
  }
  public data with_probe_id(String probe_id) {
    this.probe_id = probe_id;
    return this;
  }
  private String probe_mac;
  public String get_probe_mac() {
    return probe_mac;
  }
  public void set_probe_mac(String probe_mac) {
    this.probe_mac = probe_mac;
  }
  public data with_probe_mac(String probe_mac) {
    this.probe_mac = probe_mac;
    return this;
  }
  private Integer rate;
  public Integer get_rate() {
    return rate;
  }
  public void set_rate(Integer rate) {
    this.rate = rate;
  }
  public data with_rate(Integer rate) {
    this.rate = rate;
    return this;
  }
  private String wssid;
  public String get_wssid() {
    return wssid;
  }
  public void set_wssid(String wssid) {
    this.wssid = wssid;
  }
  public data with_wssid(String wssid) {
    this.wssid = wssid;
    return this;
  }
  private String wmac;
  public String get_wmac() {
    return wmac;
  }
  public void set_wmac(String wmac) {
    this.wmac = wmac;
  }
  public data with_wmac(String wmac) {
    this.wmac = wmac;
    return this;
  }
  private java.sql.Timestamp time;
  public java.sql.Timestamp get_time() {
    return time;
  }
  public void set_time(java.sql.Timestamp time) {
    this.time = time;
  }
  public data with_time(java.sql.Timestamp time) {
    this.time = time;
    return this;
  }
  private Double lat;
  public Double get_lat() {
    return lat;
  }
  public void set_lat(Double lat) {
    this.lat = lat;
  }
  public data with_lat(Double lat) {
    this.lat = lat;
    return this;
  }
  private Double lon;
  public Double get_lon() {
    return lon;
  }
  public void set_lon(Double lon) {
    this.lon = lon;
  }
  public data with_lon(Double lon) {
    this.lon = lon;
    return this;
  }
  private String addr;
  public String get_addr() {
    return addr;
  }
  public void set_addr(String addr) {
    this.addr = addr;
  }
  public data with_addr(String addr) {
    this.addr = addr;
    return this;
  }
  private String phone_mac;
  public String get_phone_mac() {
    return phone_mac;
  }
  public void set_phone_mac(String phone_mac) {
    this.phone_mac = phone_mac;
  }
  public data with_phone_mac(String phone_mac) {
    this.phone_mac = phone_mac;
    return this;
  }
  private Integer phone_rssi;
  public Integer get_phone_rssi() {
    return phone_rssi;
  }
  public void set_phone_rssi(Integer phone_rssi) {
    this.phone_rssi = phone_rssi;
  }
  public data with_phone_rssi(Integer phone_rssi) {
    this.phone_rssi = phone_rssi;
    return this;
  }
  private Integer phone_range;
  public Integer get_phone_range() {
    return phone_range;
  }
  public void set_phone_range(Integer phone_range) {
    this.phone_range = phone_range;
  }
  public data with_phone_range(Integer phone_range) {
    this.phone_range = phone_range;
    return this;
  }
  private String phone_tmc;
  public String get_phone_tmc() {
    return phone_tmc;
  }
  public void set_phone_tmc(String phone_tmc) {
    this.phone_tmc = phone_tmc;
  }
  public data with_phone_tmc(String phone_tmc) {
    this.phone_tmc = phone_tmc;
    return this;
  }
  private Boolean tc;
  public Boolean get_tc() {
    return tc;
  }
  public void set_tc(Boolean tc) {
    this.tc = tc;
  }
  public data with_tc(Boolean tc) {
    this.tc = tc;
    return this;
  }
  private Boolean ds;
  public Boolean get_ds() {
    return ds;
  }
  public void set_ds(Boolean ds) {
    this.ds = ds;
  }
  public data with_ds(Boolean ds) {
    this.ds = ds;
    return this;
  }
  private String essid;
  public String get_essid() {
    return essid;
  }
  public void set_essid(String essid) {
    this.essid = essid;
  }
  public data with_essid(String essid) {
    this.essid = essid;
    return this;
  }
  private String ts;
  public String get_ts() {
    return ts;
  }
  public void set_ts(String ts) {
    this.ts = ts;
  }
  public data with_ts(String ts) {
    this.ts = ts;
    return this;
  }
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public data with_id(Integer id) {
    this.id = id;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof data)) {
      return false;
    }
    data that = (data) o;
    boolean equal = true;
    equal = equal && (this.probe_id == null ? that.probe_id == null : this.probe_id.equals(that.probe_id));
    equal = equal && (this.probe_mac == null ? that.probe_mac == null : this.probe_mac.equals(that.probe_mac));
    equal = equal && (this.rate == null ? that.rate == null : this.rate.equals(that.rate));
    equal = equal && (this.wssid == null ? that.wssid == null : this.wssid.equals(that.wssid));
    equal = equal && (this.wmac == null ? that.wmac == null : this.wmac.equals(that.wmac));
    equal = equal && (this.time == null ? that.time == null : this.time.equals(that.time));
    equal = equal && (this.lat == null ? that.lat == null : this.lat.equals(that.lat));
    equal = equal && (this.lon == null ? that.lon == null : this.lon.equals(that.lon));
    equal = equal && (this.addr == null ? that.addr == null : this.addr.equals(that.addr));
    equal = equal && (this.phone_mac == null ? that.phone_mac == null : this.phone_mac.equals(that.phone_mac));
    equal = equal && (this.phone_rssi == null ? that.phone_rssi == null : this.phone_rssi.equals(that.phone_rssi));
    equal = equal && (this.phone_range == null ? that.phone_range == null : this.phone_range.equals(that.phone_range));
    equal = equal && (this.phone_tmc == null ? that.phone_tmc == null : this.phone_tmc.equals(that.phone_tmc));
    equal = equal && (this.tc == null ? that.tc == null : this.tc.equals(that.tc));
    equal = equal && (this.ds == null ? that.ds == null : this.ds.equals(that.ds));
    equal = equal && (this.essid == null ? that.essid == null : this.essid.equals(that.essid));
    equal = equal && (this.ts == null ? that.ts == null : this.ts.equals(that.ts));
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof data)) {
      return false;
    }
    data that = (data) o;
    boolean equal = true;
    equal = equal && (this.probe_id == null ? that.probe_id == null : this.probe_id.equals(that.probe_id));
    equal = equal && (this.probe_mac == null ? that.probe_mac == null : this.probe_mac.equals(that.probe_mac));
    equal = equal && (this.rate == null ? that.rate == null : this.rate.equals(that.rate));
    equal = equal && (this.wssid == null ? that.wssid == null : this.wssid.equals(that.wssid));
    equal = equal && (this.wmac == null ? that.wmac == null : this.wmac.equals(that.wmac));
    equal = equal && (this.time == null ? that.time == null : this.time.equals(that.time));
    equal = equal && (this.lat == null ? that.lat == null : this.lat.equals(that.lat));
    equal = equal && (this.lon == null ? that.lon == null : this.lon.equals(that.lon));
    equal = equal && (this.addr == null ? that.addr == null : this.addr.equals(that.addr));
    equal = equal && (this.phone_mac == null ? that.phone_mac == null : this.phone_mac.equals(that.phone_mac));
    equal = equal && (this.phone_rssi == null ? that.phone_rssi == null : this.phone_rssi.equals(that.phone_rssi));
    equal = equal && (this.phone_range == null ? that.phone_range == null : this.phone_range.equals(that.phone_range));
    equal = equal && (this.phone_tmc == null ? that.phone_tmc == null : this.phone_tmc.equals(that.phone_tmc));
    equal = equal && (this.tc == null ? that.tc == null : this.tc.equals(that.tc));
    equal = equal && (this.ds == null ? that.ds == null : this.ds.equals(that.ds));
    equal = equal && (this.essid == null ? that.essid == null : this.essid.equals(that.essid));
    equal = equal && (this.ts == null ? that.ts == null : this.ts.equals(that.ts));
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.probe_id = JdbcWritableBridge.readString(1, __dbResults);
    this.probe_mac = JdbcWritableBridge.readString(2, __dbResults);
    this.rate = JdbcWritableBridge.readInteger(3, __dbResults);
    this.wssid = JdbcWritableBridge.readString(4, __dbResults);
    this.wmac = JdbcWritableBridge.readString(5, __dbResults);
    this.time = JdbcWritableBridge.readTimestamp(6, __dbResults);
    this.lat = JdbcWritableBridge.readDouble(7, __dbResults);
    this.lon = JdbcWritableBridge.readDouble(8, __dbResults);
    this.addr = JdbcWritableBridge.readString(9, __dbResults);
    this.phone_mac = JdbcWritableBridge.readString(10, __dbResults);
    this.phone_rssi = JdbcWritableBridge.readInteger(11, __dbResults);
    this.phone_range = JdbcWritableBridge.readInteger(12, __dbResults);
    this.phone_tmc = JdbcWritableBridge.readString(13, __dbResults);
    this.tc = JdbcWritableBridge.readBoolean(14, __dbResults);
    this.ds = JdbcWritableBridge.readBoolean(15, __dbResults);
    this.essid = JdbcWritableBridge.readString(16, __dbResults);
    this.ts = JdbcWritableBridge.readString(17, __dbResults);
    this.id = JdbcWritableBridge.readInteger(18, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.probe_id = JdbcWritableBridge.readString(1, __dbResults);
    this.probe_mac = JdbcWritableBridge.readString(2, __dbResults);
    this.rate = JdbcWritableBridge.readInteger(3, __dbResults);
    this.wssid = JdbcWritableBridge.readString(4, __dbResults);
    this.wmac = JdbcWritableBridge.readString(5, __dbResults);
    this.time = JdbcWritableBridge.readTimestamp(6, __dbResults);
    this.lat = JdbcWritableBridge.readDouble(7, __dbResults);
    this.lon = JdbcWritableBridge.readDouble(8, __dbResults);
    this.addr = JdbcWritableBridge.readString(9, __dbResults);
    this.phone_mac = JdbcWritableBridge.readString(10, __dbResults);
    this.phone_rssi = JdbcWritableBridge.readInteger(11, __dbResults);
    this.phone_range = JdbcWritableBridge.readInteger(12, __dbResults);
    this.phone_tmc = JdbcWritableBridge.readString(13, __dbResults);
    this.tc = JdbcWritableBridge.readBoolean(14, __dbResults);
    this.ds = JdbcWritableBridge.readBoolean(15, __dbResults);
    this.essid = JdbcWritableBridge.readString(16, __dbResults);
    this.ts = JdbcWritableBridge.readString(17, __dbResults);
    this.id = JdbcWritableBridge.readInteger(18, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(probe_id, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(probe_mac, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(rate, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(wssid, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(wmac, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(time, 6 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeDouble(lat, 7 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(lon, 8 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(addr, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(phone_mac, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(phone_rssi, 11 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(phone_range, 12 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(phone_tmc, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(tc, 14 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(ds, 15 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeString(essid, 16 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(ts, 17 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(id, 18 + __off, 4, __dbStmt);
    return 18;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(probe_id, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(probe_mac, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(rate, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(wssid, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(wmac, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(time, 6 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeDouble(lat, 7 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(lon, 8 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(addr, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(phone_mac, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(phone_rssi, 11 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(phone_range, 12 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(phone_tmc, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(tc, 14 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(ds, 15 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeString(essid, 16 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(ts, 17 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(id, 18 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.probe_id = null;
    } else {
    this.probe_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.probe_mac = null;
    } else {
    this.probe_mac = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.rate = null;
    } else {
    this.rate = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.wssid = null;
    } else {
    this.wssid = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wmac = null;
    } else {
    this.wmac = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.time = null;
    } else {
    this.time = new Timestamp(__dataIn.readLong());
    this.time.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.lat = null;
    } else {
    this.lat = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.lon = null;
    } else {
    this.lon = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.addr = null;
    } else {
    this.addr = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.phone_mac = null;
    } else {
    this.phone_mac = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.phone_rssi = null;
    } else {
    this.phone_rssi = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.phone_range = null;
    } else {
    this.phone_range = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.phone_tmc = null;
    } else {
    this.phone_tmc = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.tc = null;
    } else {
    this.tc = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.ds = null;
    } else {
    this.ds = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.essid = null;
    } else {
    this.essid = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.ts = null;
    } else {
    this.ts = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.probe_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, probe_id);
    }
    if (null == this.probe_mac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, probe_mac);
    }
    if (null == this.rate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.rate);
    }
    if (null == this.wssid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wssid);
    }
    if (null == this.wmac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wmac);
    }
    if (null == this.time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time.getTime());
    __dataOut.writeInt(this.time.getNanos());
    }
    if (null == this.lat) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.lat);
    }
    if (null == this.lon) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.lon);
    }
    if (null == this.addr) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, addr);
    }
    if (null == this.phone_mac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, phone_mac);
    }
    if (null == this.phone_rssi) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.phone_rssi);
    }
    if (null == this.phone_range) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.phone_range);
    }
    if (null == this.phone_tmc) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, phone_tmc);
    }
    if (null == this.tc) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.tc);
    }
    if (null == this.ds) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.ds);
    }
    if (null == this.essid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, essid);
    }
    if (null == this.ts) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ts);
    }
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.probe_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, probe_id);
    }
    if (null == this.probe_mac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, probe_mac);
    }
    if (null == this.rate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.rate);
    }
    if (null == this.wssid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wssid);
    }
    if (null == this.wmac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wmac);
    }
    if (null == this.time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time.getTime());
    __dataOut.writeInt(this.time.getNanos());
    }
    if (null == this.lat) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.lat);
    }
    if (null == this.lon) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.lon);
    }
    if (null == this.addr) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, addr);
    }
    if (null == this.phone_mac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, phone_mac);
    }
    if (null == this.phone_rssi) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.phone_rssi);
    }
    if (null == this.phone_range) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.phone_range);
    }
    if (null == this.phone_tmc) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, phone_tmc);
    }
    if (null == this.tc) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.tc);
    }
    if (null == this.ds) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.ds);
    }
    if (null == this.essid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, essid);
    }
    if (null == this.ts) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ts);
    }
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 9, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(probe_id==null?"null":probe_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(probe_mac==null?"null":probe_mac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rate==null?"null":"" + rate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wssid==null?"null":wssid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wmac==null?"null":wmac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time==null?"null":"" + time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lat==null?"null":"" + lat, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lon==null?"null":"" + lon, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(addr==null?"null":addr, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone_mac==null?"null":phone_mac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone_rssi==null?"null":"" + phone_rssi, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone_range==null?"null":"" + phone_range, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone_tmc==null?"null":phone_tmc, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tc==null?"null":"" + tc, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ds==null?"null":"" + ds, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(essid==null?"null":essid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ts==null?"null":ts, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(probe_id==null?"null":probe_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(probe_mac==null?"null":probe_mac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rate==null?"null":"" + rate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wssid==null?"null":wssid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wmac==null?"null":wmac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time==null?"null":"" + time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lat==null?"null":"" + lat, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lon==null?"null":"" + lon, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(addr==null?"null":addr, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone_mac==null?"null":phone_mac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone_rssi==null?"null":"" + phone_rssi, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone_range==null?"null":"" + phone_range, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(phone_tmc==null?"null":phone_tmc, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tc==null?"null":"" + tc, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ds==null?"null":"" + ds, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(essid==null?"null":essid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ts==null?"null":ts, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 9, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.probe_id = null; } else {
      this.probe_id = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.probe_mac = null; } else {
      this.probe_mac = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rate = null; } else {
      this.rate = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.wssid = null; } else {
      this.wssid = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.wmac = null; } else {
      this.wmac = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time = null; } else {
      this.time = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.lat = null; } else {
      this.lat = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.lon = null; } else {
      this.lon = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.addr = null; } else {
      this.addr = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.phone_mac = null; } else {
      this.phone_mac = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.phone_rssi = null; } else {
      this.phone_rssi = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.phone_range = null; } else {
      this.phone_range = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.phone_tmc = null; } else {
      this.phone_tmc = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tc = null; } else {
      this.tc = BooleanParser.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ds = null; } else {
      this.ds = BooleanParser.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.essid = null; } else {
      this.essid = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ts = null; } else {
      this.ts = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.probe_id = null; } else {
      this.probe_id = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.probe_mac = null; } else {
      this.probe_mac = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rate = null; } else {
      this.rate = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.wssid = null; } else {
      this.wssid = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.wmac = null; } else {
      this.wmac = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time = null; } else {
      this.time = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.lat = null; } else {
      this.lat = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.lon = null; } else {
      this.lon = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.addr = null; } else {
      this.addr = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.phone_mac = null; } else {
      this.phone_mac = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.phone_rssi = null; } else {
      this.phone_rssi = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.phone_range = null; } else {
      this.phone_range = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.phone_tmc = null; } else {
      this.phone_tmc = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tc = null; } else {
      this.tc = BooleanParser.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ds = null; } else {
      this.ds = BooleanParser.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.essid = null; } else {
      this.essid = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ts = null; } else {
      this.ts = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    data o = (data) super.clone();
    o.time = (o.time != null) ? (java.sql.Timestamp) o.time.clone() : null;
    return o;
  }

  public void clone0(data o) throws CloneNotSupportedException {
    o.time = (o.time != null) ? (java.sql.Timestamp) o.time.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("probe_id", this.probe_id);
    __sqoop$field_map.put("probe_mac", this.probe_mac);
    __sqoop$field_map.put("rate", this.rate);
    __sqoop$field_map.put("wssid", this.wssid);
    __sqoop$field_map.put("wmac", this.wmac);
    __sqoop$field_map.put("time", this.time);
    __sqoop$field_map.put("lat", this.lat);
    __sqoop$field_map.put("lon", this.lon);
    __sqoop$field_map.put("addr", this.addr);
    __sqoop$field_map.put("phone_mac", this.phone_mac);
    __sqoop$field_map.put("phone_rssi", this.phone_rssi);
    __sqoop$field_map.put("phone_range", this.phone_range);
    __sqoop$field_map.put("phone_tmc", this.phone_tmc);
    __sqoop$field_map.put("tc", this.tc);
    __sqoop$field_map.put("ds", this.ds);
    __sqoop$field_map.put("essid", this.essid);
    __sqoop$field_map.put("ts", this.ts);
    __sqoop$field_map.put("id", this.id);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("probe_id", this.probe_id);
    __sqoop$field_map.put("probe_mac", this.probe_mac);
    __sqoop$field_map.put("rate", this.rate);
    __sqoop$field_map.put("wssid", this.wssid);
    __sqoop$field_map.put("wmac", this.wmac);
    __sqoop$field_map.put("time", this.time);
    __sqoop$field_map.put("lat", this.lat);
    __sqoop$field_map.put("lon", this.lon);
    __sqoop$field_map.put("addr", this.addr);
    __sqoop$field_map.put("phone_mac", this.phone_mac);
    __sqoop$field_map.put("phone_rssi", this.phone_rssi);
    __sqoop$field_map.put("phone_range", this.phone_range);
    __sqoop$field_map.put("phone_tmc", this.phone_tmc);
    __sqoop$field_map.put("tc", this.tc);
    __sqoop$field_map.put("ds", this.ds);
    __sqoop$field_map.put("essid", this.essid);
    __sqoop$field_map.put("ts", this.ts);
    __sqoop$field_map.put("id", this.id);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("probe_id".equals(__fieldName)) {
      this.probe_id = (String) __fieldVal;
    }
    else    if ("probe_mac".equals(__fieldName)) {
      this.probe_mac = (String) __fieldVal;
    }
    else    if ("rate".equals(__fieldName)) {
      this.rate = (Integer) __fieldVal;
    }
    else    if ("wssid".equals(__fieldName)) {
      this.wssid = (String) __fieldVal;
    }
    else    if ("wmac".equals(__fieldName)) {
      this.wmac = (String) __fieldVal;
    }
    else    if ("time".equals(__fieldName)) {
      this.time = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("lat".equals(__fieldName)) {
      this.lat = (Double) __fieldVal;
    }
    else    if ("lon".equals(__fieldName)) {
      this.lon = (Double) __fieldVal;
    }
    else    if ("addr".equals(__fieldName)) {
      this.addr = (String) __fieldVal;
    }
    else    if ("phone_mac".equals(__fieldName)) {
      this.phone_mac = (String) __fieldVal;
    }
    else    if ("phone_rssi".equals(__fieldName)) {
      this.phone_rssi = (Integer) __fieldVal;
    }
    else    if ("phone_range".equals(__fieldName)) {
      this.phone_range = (Integer) __fieldVal;
    }
    else    if ("phone_tmc".equals(__fieldName)) {
      this.phone_tmc = (String) __fieldVal;
    }
    else    if ("tc".equals(__fieldName)) {
      this.tc = (Boolean) __fieldVal;
    }
    else    if ("ds".equals(__fieldName)) {
      this.ds = (Boolean) __fieldVal;
    }
    else    if ("essid".equals(__fieldName)) {
      this.essid = (String) __fieldVal;
    }
    else    if ("ts".equals(__fieldName)) {
      this.ts = (String) __fieldVal;
    }
    else    if ("id".equals(__fieldName)) {
      this.id = (Integer) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("probe_id".equals(__fieldName)) {
      this.probe_id = (String) __fieldVal;
      return true;
    }
    else    if ("probe_mac".equals(__fieldName)) {
      this.probe_mac = (String) __fieldVal;
      return true;
    }
    else    if ("rate".equals(__fieldName)) {
      this.rate = (Integer) __fieldVal;
      return true;
    }
    else    if ("wssid".equals(__fieldName)) {
      this.wssid = (String) __fieldVal;
      return true;
    }
    else    if ("wmac".equals(__fieldName)) {
      this.wmac = (String) __fieldVal;
      return true;
    }
    else    if ("time".equals(__fieldName)) {
      this.time = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("lat".equals(__fieldName)) {
      this.lat = (Double) __fieldVal;
      return true;
    }
    else    if ("lon".equals(__fieldName)) {
      this.lon = (Double) __fieldVal;
      return true;
    }
    else    if ("addr".equals(__fieldName)) {
      this.addr = (String) __fieldVal;
      return true;
    }
    else    if ("phone_mac".equals(__fieldName)) {
      this.phone_mac = (String) __fieldVal;
      return true;
    }
    else    if ("phone_rssi".equals(__fieldName)) {
      this.phone_rssi = (Integer) __fieldVal;
      return true;
    }
    else    if ("phone_range".equals(__fieldName)) {
      this.phone_range = (Integer) __fieldVal;
      return true;
    }
    else    if ("phone_tmc".equals(__fieldName)) {
      this.phone_tmc = (String) __fieldVal;
      return true;
    }
    else    if ("tc".equals(__fieldName)) {
      this.tc = (Boolean) __fieldVal;
      return true;
    }
    else    if ("ds".equals(__fieldName)) {
      this.ds = (Boolean) __fieldVal;
      return true;
    }
    else    if ("essid".equals(__fieldName)) {
      this.essid = (String) __fieldVal;
      return true;
    }
    else    if ("ts".equals(__fieldName)) {
      this.ts = (String) __fieldVal;
      return true;
    }
    else    if ("id".equals(__fieldName)) {
      this.id = (Integer) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
