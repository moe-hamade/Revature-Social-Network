package com.revature.application.dao.beans;

import javax.persistence.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class HotSpot {

	@Id
	@SequenceGenerator(name="locationSequence", sequenceName="location_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="locationSequence")
	@NotNull
	private long hotSpotId;

	@Column(nullable = false)
	@NotNull
	@DecimalMin("-180.0")
	@DecimalMax("180.0")
	private double longitude;

	@Column(nullable = false)
	@NotNull
	@DecimalMin("-180.0")
	@DecimalMax("180.0")
	private double lattitude;

	@OneToOne
	@JoinColumn(name = "postId")
	private Post post;

	public HotSpot() {
		super();
	}

	public HotSpot(double longitude, double lattitude, Post post) {
		super();
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.post = post;
	}

	public long getHotSpotId() {
		return hotSpotId;
	}

	public void setHotSpotId(long hotSpotId) {
		this.hotSpotId = hotSpotId;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLattitude() {
		return lattitude;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "HotSpot [hotSpotId=" + hotSpotId + ", longitude=" + longitude + ", lattitude=" + lattitude + ", post="
				+ post + "]";
	}	

}