package io.jans.couchbase.test;

/*
 * oxAuth is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2014, Gluu
 */

import com.couchbase.client.java.cluster.User;
import com.google.common.collect.Maps;
import io.jans.persist.annotation.*;
import io.jans.persist.model.base.Deletable;

import javax.inject.Named;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author Yuriy Zabrovarnyy
 * @author Javier Rojas Blum
 * @version December 8, 2018
 */
@Named("sessionUser")
@DataEntry
@ObjectClass(value = "oxAuthSessionId")
public class SessionId implements Deletable, Serializable {

    private static final long serialVersionUID = -237476411915686378L;

    @DN
    private String dn;

    @AttributeName(name = "oxId")
    private String id;

    @AttributeName(name = "oxLastAccessTime")
    private Date lastUsedAt;

    @AttributeName(name = "oxAuthUserDN")
    private String userDn;

    @AttributeName(name = "authnTime")
    private Date authenticationTime;

    @AttributeName(name = "oxState")
    private SessionIdState state;

    @AttributeName(name = "oxSessionState")
    private String sessionState;

    @AttributeName(name = "oxAuthPermissionGranted")
    private Boolean permissionGranted;

    @AttributeName(name = "oxAsJwt")
    private Boolean isJwt = false;

    @AttributeName(name = "oxJwt")
    private String jwt;

    @JsonObject
    @AttributeName(name = "oxAuthSessionAttribute")
    private Map<String, String> sessionAttributes;

    @AttributeName(name = "exp")
    private Date expirationDate;

    @AttributeName(name = "del")
    private Boolean deletable = true;

    @AttributeName(name = "creationDate")
    private Date creationDate = new Date();

    @Transient
    private transient boolean persisted;

    @Transient
    private User user;

    @Expiration
    private int ttl;

    public SessionId() {
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String p_dn) {
        dn = p_dn;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Boolean getIsJwt() {
        return isJwt;
    }

    public void setIsJwt(Boolean isJwt) {
        this.isJwt = isJwt;
    }

    public SessionIdState getState() {
        return state;
    }

    public void setState(SessionIdState state) {
        this.state = state;
    }

    public String getSessionState() {
        return sessionState;
    }

    public void setSessionState(String sessionState) {
        this.sessionState = sessionState;
    }

    public String getId() {
        return id;
    }

    public void setId(String p_id) {
        id = p_id;
    }

    public Date getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(Date p_lastUsedAt) {
        lastUsedAt = p_lastUsedAt;
    }

    public String getUserDn() {
        return userDn;
    }

    public void setUserDn(String p_userDn) {
        userDn = p_userDn != null ? p_userDn : "";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAuthenticationTime() {
        return authenticationTime;
    }

    public void setAuthenticationTime(Date authenticationTime) {
        this.authenticationTime = authenticationTime;
    }

    public Boolean getPermissionGranted() {
        return permissionGranted;
    }

    public void setPermissionGranted(Boolean permissionGranted) {
        this.permissionGranted = permissionGranted;
    }

    public Map<String, String> getSessionAttributes() {
        if (sessionAttributes == null) {
            sessionAttributes = Maps.newHashMap();
        }
        return sessionAttributes;
    }

    public void setSessionAttributes(Map<String, String> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }

    public boolean isPersisted() {
        return persisted;
    }

    public void setPersisted(boolean persisted) {
        this.persisted = persisted;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean isDeletable() {
        return deletable != null ? deletable : true;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionId id1 = (SessionId) o;

        return !(id != null ? !id.equals(id1.id) : id1.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SessionIdTest {");
        sb.append("dn='").append(dn).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", lastUsedAt=").append(lastUsedAt);
        sb.append(", userDn='").append(userDn).append('\'');
        sb.append(", authenticationTime=").append(authenticationTime);
        sb.append(", state=").append(state);
        sb.append(", sessionState='").append(sessionState).append('\'');
        sb.append(", permissionGranted=").append(permissionGranted);
        sb.append(", isJwt=").append(isJwt);
        sb.append(", jwt=").append(jwt);
        sb.append(", sessionAttributes=").append(sessionAttributes);
        sb.append(", persisted=").append(persisted);
        sb.append("}");
        return sb.toString();
    }
}
