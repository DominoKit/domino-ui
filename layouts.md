# How to use Flexlayout and columns to build custom layouts in domino-ui

First while building layouts we dont pick between Columns and Flexlayout, instead we use a combination of both. and we build our layout incrementally, and while doing so we need to define how the layout should look like for big and small screens, lets have some example


- I want to build a layout where I have 2 vertical areas that are equal in size, Area A and Area B, in a small screen A and B will take full screen width and B will show up below A.

In this example we can use grid columns, grid columns are good for simple layouts were the order and is maintained in one direction :

