- simply a table in the web application
  There are 2 types of webtables:
- static webtables - the table is static, it stays the same at all times: it
  will have a constant number of rows and constant number of columns. When
  working with a static table you can hardcode a row or a column because you know
  that it will stay the same
  -dynamic webtables - can change in size and entries may also change a lot. When
  working with dynamic tables no hardcoding should be done because the
  information in the table and the actual table may change and there is no
  quarantee that the information in row 2 will stay in row 2.
  To get the number of rows in the table - count <tr>
  To get the number of columns in the table - count <td> in only 1 row
<table>
<tr>
<th> Name</th>
<th> Age</th>
</tr>
<tr>
<td> Joe</td>
<td> 32</td>
</tr>
<tr>
</tr>
</table>