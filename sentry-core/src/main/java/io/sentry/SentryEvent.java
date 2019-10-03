package io.sentry;

import io.sentry.protocol.Message;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentryEvent {
  private SentryId eventId;
  private Date timestamp;
  private Throwable throwable;
  private Message message;
  private String serverName;
  private String platform;
  private String release;
  private String logger;
  private SentryValues<SentryThread> threads;
  private SentryValues<SentryException> exceptions;
  private SentryLevel level;
  private String transaction;
  private String environment;
  private User user;
  private Request request;
  private SdkVersion sdkVersion;
  private List<String> fingerprint = new ArrayList<>();
  private List<Breadcrumb> breadcrumbs = new ArrayList<>();
  private Map<String, String> tags = new HashMap<>();
  private Map<String, Object> extra = new HashMap<>();

  SentryEvent(SentryId eventId, Date timestamp) {
    this.eventId = eventId;
    this.timestamp = timestamp;
  }

  public SentryEvent(Throwable throwable) {
    this();
    this.throwable = throwable;
  }

  public SentryEvent() {
    this(new SentryId(), DateUtils.getCurrentDateTime());
  }

  public SentryId getEventId() {
    return eventId;
  }

  public Date getTimestamp() {
    return (Date) timestamp.clone();
  }

  String getTimestampIsoFormat() {
    return DateUtils.getTimestampIsoFormat(timestamp);
  }

  Throwable getThrowable() {
    return throwable;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public String getRelease() {
    return release;
  }

  public void setRelease(String release) {
    this.release = release;
  }

  public String getLogger() {
    return logger;
  }

  public void setLogger(String logger) {
    this.logger = logger;
  }

  public List<SentryThread> getThreads() {
    return threads.getValues();
  }

  public void setThreads(List<SentryThread> threads) {
    this.threads = new SentryValues<>(threads);
  }

  public List<SentryException> getExceptions() {
    return exceptions.getValues();
  }

  public void setExceptions(List<SentryException> exceptions) {
    this.exceptions = new SentryValues<>(exceptions);
  }

  public void setEventId(SentryId eventId) {
    this.eventId = eventId;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public void setThrowable(Throwable throwable) {
    this.throwable = throwable;
  }

  public void setThreads(SentryValues<SentryThread> threads) {
    this.threads = threads;
  }

  public void setExceptions(SentryValues<SentryException> exceptions) {
    this.exceptions = exceptions;
  }

  public SentryLevel getLevel() {
    return level;
  }

  public void setLevel(SentryLevel level) {
    this.level = level;
  }

  public String getTransaction() {
    return transaction;
  }

  public void setTransaction(String transaction) {
    this.transaction = transaction;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public SdkVersion getSdkVersion() {
    return sdkVersion;
  }

  public void setSdkVersion(SdkVersion sdkVersion) {
    this.sdkVersion = sdkVersion;
  }

  public List<String> getFingerprint() {
    return fingerprint;
  }

  public void setFingerprint(List<String> fingerprint) {
    this.fingerprint = fingerprint;
  }

  public List<Breadcrumb> getBreadcrumbs() {
    return breadcrumbs;
  }

  public void setBreadcrumbs(ArrayList<Breadcrumb> breadcrumbs) {
    this.breadcrumbs = breadcrumbs;
  }

  public Map<String, String> getTags() {
    return tags;
  }

  public void setTags(HashMap<String, String> tags) {
    this.tags = tags;
  }

  public Map<String, Object> getExtra() {
    return extra;
  }

  public void setExtra(HashMap<String, Object> extra) {
    this.extra = extra;
  }
}
