-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2017 年 01 月 04 日 15:34
-- 服务器版本: 5.5.20
-- PHP 版本: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `students`
--

-- --------------------------------------------------------

--
-- 表的结构 `student_admin`
--

CREATE TABLE IF NOT EXISTS `student_admin` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `username` char(255) NOT NULL,
  `password` char(255) NOT NULL,
  `name` char(255) NOT NULL,
  `phone` char(255) NOT NULL,
  `email` char(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL,
  `work` char(255) NOT NULL,
  `type` int(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `student_admin`
--

INSERT INTO `student_admin` (`id`, `username`, `password`, `name`, `phone`, `email`, `work`, `type`) VALUES
(1, 'admin', 'admin', '李晓春', '17865923605', '1174822726@qq.com', '信息楼405室', 1),
(5, 'lgqn', 'lgqn', 'lzx', '8515038', '7878787887@qq.com', '410', 1);

-- --------------------------------------------------------

--
-- 表的结构 `student_book`
--

CREATE TABLE IF NOT EXISTS `student_book` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `studentid` char(255) NOT NULL,
  `bookname` char(255) NOT NULL,
  `chengji` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `student_book`
--

INSERT INTO `student_book` (`id`, `studentid`, `bookname`, `chengji`) VALUES
(1, '14110506015', 'Math', '100');

-- --------------------------------------------------------

--
-- 表的结构 `student_class`
--

CREATE TABLE IF NOT EXISTS `student_class` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `classid` char(255) NOT NULL,
  `classname` char(255) NOT NULL,
  `classs` char(255) NOT NULL,
  `classmust` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `student_class`
--

INSERT INTO `student_class` (`id`, `classid`, `classname`, `classs`, `classmust`) VALUES
(1, '1001', 'Math', '物理学院', '必修课'),
(2, '1002', 'English', 'English school', 'publice'),
(3, '1003', 'jisuanji', 'jisuanjikexue', 'publice');

-- --------------------------------------------------------

--
-- 表的结构 `student_stu`
--

CREATE TABLE IF NOT EXISTS `student_stu` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `studentid` char(255) NOT NULL,
  `studentsex` char(255) NOT NULL,
  `studentclass` char(255) NOT NULL,
  `studentyear` char(255) NOT NULL,
  `studentname` char(255) NOT NULL,
  `studentpassword` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `student_stu`
--

INSERT INTO `student_stu` (`id`, `studentid`, `studentsex`, `studentclass`, `studentyear`, `studentname`, `studentpassword`) VALUES
(1, '14110506015', 'man', 'ruanjian1405', '2014', 'lzx', '14110506015');

-- --------------------------------------------------------

--
-- 表的结构 `student_teacher`
--

CREATE TABLE IF NOT EXISTS `student_teacher` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `teacherid` char(255) NOT NULL,
  `teacherpassword` varchar(255) NOT NULL,
  `teachername` char(255) NOT NULL,
  `teacherfrom` char(255) NOT NULL,
  `teachersex` char(255) NOT NULL,
  `teacherphone` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `student_teacher`
--

INSERT INTO `student_teacher` (`id`, `teacherid`, `teacherpassword`, `teachername`, `teacherfrom`, `teachersex`, `teacherphone`) VALUES
(1, '20141002', '20141002', '刘夏恩', '计算机科学与技术学院', 'man', '17865324711');

-- --------------------------------------------------------

--
-- 表的结构 `teacher_book`
--

CREATE TABLE IF NOT EXISTS `teacher_book` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `teacherid` char(255) NOT NULL,
  `bookname` char(255) NOT NULL,
  `bookhouse` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `teacher_book`
--

INSERT INTO `teacher_book` (`id`, `teacherid`, `bookname`, `bookhouse`) VALUES
(1, '20141002', '离散数学', '6#402'),
(2, '20141002', '大学物理', '5#402'),
(3, '20141003', '离散数学', '1#402'),
(4, '20141002', 'Math', '1#402'),
(5, '20141002', 'English', '6#302');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
