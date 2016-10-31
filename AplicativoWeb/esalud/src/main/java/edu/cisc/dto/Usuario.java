package edu.cisc.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class Usuario implements org.springframework.security.core.userdetails.UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
    private String password;
    boolean status = false;
    private Collection<GrantedAuthority> list;
    
    public Usuario() {
    }

    public Usuario(String username) {
        this.username = username;
    }    

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}    
    
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	public void setPassword(String password) {
		this.password = password;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
    public Collection<GrantedAuthority> getAuthorities() {
        return list;
    }  	

    public void setAuthorities(Collection<GrantedAuthority> roles) {
        this.list = roles;
    }
    
    public void setAuthentication(boolean status) {
        this.status = status;
    }    

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }
    
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }
    
    public String toString() {
        return "[ usuario=" + username + " ]";
    }   

}
