package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	//annotate the class as an entity and map to DB Table
	
	//define the fields
		
	//annotate the field with db column names
	
	//create constructor
	
	//generate getter and setter
	
	//generate toString()
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	

	/**to only delete Instructor Detail and not Instructor
	 * we use cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST
	 * 					CascadeType.REFRESH}
	 * 
	 * CascadeType.REMOVE should not be included
	 */
	//we can use the mappedBy parameter to indicate that the given column is owned by another entity:
	//making it bi-directional
	//refers to "instructorDetail" property in "instructor" class
	//@OneToOne(mappedBy="instructorDetail" , cascade=CascadeType.ALL)
	@OneToOne(mappedBy="instructorDetail" , 
			cascade= {CascadeType.DETACH , CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor theInstructor;

	public InstructorDetail()
	{
		
	}
	
	public InstructorDetail( String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public Instructor getTheInstructor() {
		return theInstructor;
	}

	public void setTheInstructor(Instructor theInstructor) {
		this.theInstructor = theInstructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	

}
