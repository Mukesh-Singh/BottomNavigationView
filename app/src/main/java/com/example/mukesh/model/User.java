package com.example.mukesh.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Mukesh Singh on 12/11/2019
 */
public class User implements Parcelable {

    /**
     * _id : 5df09dbe473bd48e8294e7d5
     * index : 0
     * guid : 648841e4-5cc7-4c30-9ebd-a26be6116e4e
     * isActive : false
     * balance : $2,842.36
     * picture : http://placehold.it/32x32
     * profile_pic : https://images.unsplash.com/profile-1562879881254-56eb37673331?ixlib=rb-1.2.1&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32
     * banner : https://images.unsplash.com/photo-1562886812-41775a01195d?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjEwNTg5M30
     * age : 34
     * eyeColor : blue
     * name : {"first":"Effie","last":"Page"}
     * company : BUNGA
     * email : effie.page@bunga.org
     * phone : +1 (869) 596-2470
     * address : 504 Bay Parkway, Bawcomville, West Virginia, 5180
     * about : <TypeError: loremIpsum is not a function>
     * registered : Sunday, January 24, 2016 1:34 PM
     * latitude : 64.811912
     * longitude : 173.914368
     * tags : ["<TypeError: loremIpsum is not a function>","<TypeError: loremIpsum is not a function>","<TypeError: loremIpsum is not a function>","<TypeError: loremIpsum is not a function>","<TypeError: loremIpsum is not a function>"]
     * range : [0,1,2,3,4,5,6,7,8,9]
     * friends : [{"id":0,"name":"Harvey Rodriguez"},{"id":1,"name":"Mercedes Jones"},{"id":2,"name":"Regina Davis"}]
     * greeting : Hello, Effie! You have 9 unread messages.
     * favoriteFruit : banana
     */

    private String _id;
    private int index;
    private String guid;
    private boolean isActive;
    private String balance;
    private String picture;
    private String profile_pic;
    private String banner;
    private int age;
    private String eyeColor;
    private NameBean name;
    private String company;
    private String email;
    private String phone;
    private String address;
    private String about;
    private String registered;
    private String latitude;
    private String longitude;
    private String greeting;
    private String favoriteFruit;
    private List<String> tags;
    private List<Integer> range;
    private List<FriendsBean> friends;

    protected User(Parcel in) {
        _id = in.readString();
        index = in.readInt();
        guid = in.readString();
        isActive = in.readByte() != 0;
        balance = in.readString();
        picture = in.readString();
        profile_pic = in.readString();
        banner = in.readString();
        age = in.readInt();
        eyeColor = in.readString();
        company = in.readString();
        email = in.readString();
        phone = in.readString();
        address = in.readString();
        about = in.readString();
        registered = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        greeting = in.readString();
        favoriteFruit = in.readString();
        tags = in.createStringArrayList();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public NameBean getName() {
        return name;
    }

    public void setName(NameBean name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Integer> getRange() {
        return range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }

    public List<FriendsBean> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendsBean> friends) {
        this.friends = friends;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_id);
        parcel.writeInt(index);
        parcel.writeString(guid);
        parcel.writeByte((byte) (isActive ? 1 : 0));
        parcel.writeString(balance);
        parcel.writeString(picture);
        parcel.writeString(profile_pic);
        parcel.writeString(banner);
        parcel.writeInt(age);
        parcel.writeString(eyeColor);
        parcel.writeString(company);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(address);
        parcel.writeString(about);
        parcel.writeString(registered);
        parcel.writeString(latitude);
        parcel.writeString(longitude);
        parcel.writeString(greeting);
        parcel.writeString(favoriteFruit);
        parcel.writeStringList(tags);
    }

    public static class NameBean implements Parcelable{
        /**
         * first : Effie
         * last : Page
         */

        private String first;
        private String last;

        protected NameBean(Parcel in) {
            first = in.readString();
            last = in.readString();
        }

        public static final Creator<NameBean> CREATOR = new Creator<NameBean>() {
            @Override
            public NameBean createFromParcel(Parcel in) {
                return new NameBean(in);
            }

            @Override
            public NameBean[] newArray(int size) {
                return new NameBean[size];
            }
        };

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(first);
            parcel.writeString(last);
        }
    }

    public static class FriendsBean implements Parcelable{
        /**
         * id : 0
         * name : Harvey Rodriguez
         */

        private int id;
        private String name;

        protected FriendsBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
        }

        public static final Creator<FriendsBean> CREATOR = new Creator<FriendsBean>() {
            @Override
            public FriendsBean createFromParcel(Parcel in) {
                return new FriendsBean(in);
            }

            @Override
            public FriendsBean[] newArray(int size) {
                return new FriendsBean[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
        }
    }
}
