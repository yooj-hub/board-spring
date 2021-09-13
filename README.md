# Board

## 목표

- Spring을 이용한 게시판 제작
- Spring 및 html, css, js 등 다양한 기술 사용





---



## 사용 기술



- Front

  - Html / css / javascript / thymeleaf / bootstrap

    

- BackEnd

  - Spring boot, SpringMVC, Spring Data JPA ,JPA, java8

    

- DB

  - h2Database

  
  
  
  
  ---
  
  

## 게시판의 기능

- 게시물 추가 기능 (09/12)
- 게시물 수정(09/05)
- 게시물 검색(09/12)
- 게시물 리스트 보기(09/05)
- 게시물 상세 보기(09/05)

##### 부가 기능 추가

- form 에서 field에 따른 validation 추가
- edit에서 삭제 기능 추가(09/13)



URL

시작 및 기능 일부 구현

https://yoojsblog.tistory.com/159?category=960068

기본 외형 구현

https://yoojsblog.tistory.com/166?category=960068

Validation 및 수정 및 검색 구현

https://yoojsblog.tistory.com/167

마크업 마무리 및 css 정리 및 layout 을 이용한 html 정리

https://yoojsblog.tistory.com/168?category=960068

회고

https://yoojsblog.tistory.com/169?category=960068



---



## 이 토이 프로젝트를 하면서 느낀 것

### 개인적으로 생각한 잘된 점 및 좋았던 점



- 현재까지 아는 것을 어느정도 종합해서 만들 수 있어 좋았다.

- 이번에 Spring Data JPA 와 JPA에서 쿼리수에 대한 공부를 하였는데 이를 최대한 지키도록 하였다.

- 데이터를 웹에 맞게 새로운 Dto 및 Form을 만들어 관리하여 필요이상의 데이터가 넘어가지 않도록 하였다.

  (List 조회시 Dto를 이용하여 조회 등 Web에서 사용할 객체를 분리하여 구성하였다.)

  ```java
  @Query("select new study.board.web.BulletinListDtoV2(b.id,b.subject,b.author) from Bulletin b order by b.id desc ")
  List<BulletinListDtoV2> findAllByBulletinListDto();
  ```

- 직접 마크업을 해보면서 마크업의 어려움을 알아 좋았다.





#### 개인적으로 고생했던 점 및 잘 모르겠던 점



- Thymeleaf를 통하여 삭제기능을 구현하려 했는데 타임리프로 삭제를 할 경우 제대로 작동이 되지 않았다. 이를 해결하기 위해 javascript를 따로 작성하여 해결하였다. 

```html
<!--            <button type="submit"  class="btn btn-danger" th:onclick="|location.href='@{/board/{id}/delete(id=*{id})}'|" th:formmethod="POST">Delete</button>-->
                        <a href="#" th:href="'javascript:del('+*{id}+')'" class="btn btn-danger" style="margin-top: 10px">Delete
                        </a>
```

- css 및 html으로 마크업을 하는 과정에 애로사항이 상당히 많았다. 클래스 명 및 display 등 다양한 곳에서 많은 시간이 소비되었다.
- css를 각 프로그램마다 따로 저장하여 이 css의 관리에 대해서 처음부터 해당 파일만 쓸 css가 아닐 경우 따로 css파일을 저장해야 함을 느꼈다. 또한 nav var와 같이 중복되는 것은 fragment를 통하여 관리해야 함이 편하고 에러가 적게 발생함을 알았다.
- Validation에서 BindingResult를 이용하는데 Th:action 태그가 없어서 이 떄 이 문제를 찾느라 상당한 시간을 소비했다.



#### 차기 프로젝트 및 차후 공부 방향

- Spring Data JPA를 공부를 어느정도 마무리 한 후 Vue.js와 통신을 하는 자바 프로그램 제작을 해볼 것이다.
- 이번에 마크업에 대하여 상당히 부족함을 느꼈고 마크업을 보기 나쁘지 않은 정도 까지 공부해볼 생각이다.



