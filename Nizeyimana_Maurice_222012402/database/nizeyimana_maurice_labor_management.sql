-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 10:03 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nizeyimana_maurice_labor_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(75) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `id_number` varchar(60) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `martial_status` varchar(45) DEFAULT NULL,
  `DoB` varchar(50) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `password` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('Maurice', 'NIzeyimana', '12345', '0791051095', 'Male', 'Single', '2000-07-25', 'nizeyimanamaurice123@gmail.com', 'maurice@55'),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('Ingabire', 'Catheline', '1234567', '0788812345', 'Female', 'married', '1999-05-12', 'ingabire@gmail.com', 'ingabire@33'),
('Ingabire', 'Catheline', '1234567', '0788812345', 'Female', 'married', '1999-05-12', 'ingabire@gmail.com', 'ingabire@33'),
('Ingabire', 'Catheline', '1234567', '0788812345', 'Female', 'married', '1999-05-12', 'ingabire@gmail.com', 'ingabire@33'),
('Ingabire', 'Catheline', '1234567', '0788812345', 'Female', 'married', '1999-05-12', 'ingabire@gmail.com', 'ingabire@33'),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('nelly', 'yvone', '567654567', '09787877', 'Female', 'single', '2000', 'nelly@gmail.com', '45'),
('ange', 'marie', '234567', '07888899999', 'Female', 'engaged', '1999', 'ang@gmail.com', '33'),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('rfty', 'dfgh', '24', '2345', 'Male', 'single', '2000/11/10', 'dfgyhujk', 'dfgh'),
('rfty', 'dfgh', '24', '2345', 'Male', 'single', '2000/11/10', 'qwertyu', '123456789'),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `Attendance_Id` int(11) NOT NULL,
  `Employee_Id` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Clock_In_Time` time DEFAULT NULL,
  `Clock_Out_Time` time DEFAULT NULL,
  `Total_Hours` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`Attendance_Id`, `Employee_Id`, `Date`, `Clock_In_Time`, `Clock_Out_Time`, `Total_Hours`) VALUES
(1, 1, '2023-11-09', '11:00:00', '16:00:00', 5),
(2, 3, '2020-12-16', '08:30:00', '14:30:00', 6),
(3, 5, '2021-05-11', '09:00:00', '18:00:00', 9),
(4, 4, '2019-01-15', '09:30:00', '17:30:00', 8),
(5, 2, '2022-10-21', '09:00:00', '16:00:00', 7),
(6, 8, '2024-12-12', '07:00:00', '11:45:00', 5);

-- --------------------------------------------------------

--
-- Table structure for table `benefits`
--

CREATE TABLE `benefits` (
  `Benefit_Id` int(11) NOT NULL,
  `Employee_Id` int(11) DEFAULT NULL,
  `Health_Insurance` varchar(150) NOT NULL,
  `Retirement_Plans` varchar(350) NOT NULL,
  `Other_Benefits` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `benefits`
--

INSERT INTO `benefits` (`Benefit_Id`, `Employee_Id`, `Health_Insurance`, `Retirement_Plans`, `Other_Benefits`) VALUES
(1, 1, 'Medical Plus', 'Profit-Sharing Plans', 'Flexible Spending Account, Dental Insurance, Vision Coverage'),
(2, 2, 'HealthGuard', 'Pension Plan', 'Life Insurance, Employee Assistance Program, Wellness Program'),
(3, 5, 'Blue Cross', 'Individual Retirement Account', 'Paid Time Off, Tuition Reimbursement, Commuter Benefits'),
(4, 4, 'Aetna', 'Retirement Savings Plan', 'Stock Options, Fitness Subsidy, Legal Assistance'),
(5, 3, 'UnitedHealthcare', 'Defined Benefit Plan', 'Childcare Assistance, Disability Insurance, Travel Benefits');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Employee_Id` int(11) NOT NULL,
  `First_Name` varchar(250) DEFAULT NULL,
  `Last_Name` varchar(200) DEFAULT NULL,
  `Date_Of_Birth` date DEFAULT NULL,
  `Position` varchar(50) DEFAULT NULL,
  `Department` varchar(100) DEFAULT NULL,
  `Contact_Information` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Employee_Id`, `First_Name`, `Last_Name`, `Date_Of_Birth`, `Position`, `Department`, `Contact_Information`) VALUES
(1, 'John', 'Doe', '1990-01-15', 'Manager', 'IT', '072333344456'),
(2, 'Jane', 'Smith', '2000-05-22', 'Developer', 'Engineering', '07767676767'),
(3, 'Mike', 'Johnson', '1983-08-10', 'Analyst', 'Finance', '078333444555'),
(4, 'Emily', 'Williams', '2001-03-18', 'Designer', 'Marketing', '07934344445'),
(5, 'Chris', 'Anderson', '1995-11-25', 'Engineer', 'IT', '07811112222'),
(8, 'francoics', 'habumugisha', '2000-12-12', 'asdfghjk', 'xcvbnm,', '123456'),
(11, 'Nizeyimana', 'Maurice', '2002-07-25', 'qwertyui', 'IT', '1234567890'),
(13, 'Pauchetino', 'Mauricial', '2002-07-25', 'Manager', 'IT', '1234567890'),
(15, 'Nizeyimana', 'Maurice', '2002-07-27', 'manager', 'it', '123456789'),
(17, 'qwertg', 'qwer', '2000-09-09', 'rthj', 'fghj', 'fgh'),
(18, 'shema', 'christian', '2001-12-12', 'qwert', 'It', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `leave_request`
--

CREATE TABLE `leave_request` (
  `Request_Id` int(11) NOT NULL,
  `Employee_Id` int(11) DEFAULT NULL,
  `Leave_Type` varchar(120) DEFAULT NULL,
  `Start_Date` date DEFAULT NULL,
  `End_Date` date DEFAULT NULL,
  `Status` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leave_request`
--

INSERT INTO `leave_request` (`Request_Id`, `Employee_Id`, `Leave_Type`, `Start_Date`, `End_Date`, `Status`) VALUES
(1, 4, 'Vacation', '2020-01-01', '2020-01-07', 'Pending'),
(2, 1, 'Sick Leave', '2023-02-10', '2023-02-12', 'Approved'),
(3, 3, 'Personal Leave', '2019-03-15', '2019-03-18', 'Pending'),
(4, 2, 'Maternity Leave', '2022-04-20', '2022-05-05', 'Pending'),
(5, 5, 'Business Trip', '2023-06-01', '2023-06-05', 'Approved'),
(6, 2, 'cfv', NULL, NULL, '2'),
(7, 3, 'uburwayi', NULL, NULL, '3');

-- --------------------------------------------------------

--
-- Table structure for table `payroll`
--

CREATE TABLE `payroll` (
  `Payroll_Id` int(11) NOT NULL,
  `Employee_Id` int(11) DEFAULT NULL,
  `Salary` varchar(150) DEFAULT NULL,
  `Overtime` time DEFAULT NULL,
  `Deductions` float DEFAULT NULL,
  `Net_Pay` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payroll`
--

INSERT INTO `payroll` (`Payroll_Id`, `Employee_Id`, `Salary`, `Overtime`, `Deductions`, `Net_Pay`) VALUES
(1, 5, '50000 RWF', '02:30:00', 1000.5, 48999.5),
(2, 2, '60000 RWF', '01:45:00', 800.75, 59199.2),
(3, 3, '75000 RWF', '03:15:00', 1200.25, 73699.8),
(4, 4, '45000 RWF', '00:45:00', 500, 44499.5),
(5, 1, '80000 RWF', '02:00:00', 1500, 78499),
(12, 8, '250000', '01:00:00', 15000, 235000),
(14, 17, '100000', '02:00:00', 5000, 95000);

-- --------------------------------------------------------

--
-- Table structure for table `performance`
--

CREATE TABLE `performance` (
  `Performance_Id` int(11) NOT NULL,
  `Employee_Id` int(11) DEFAULT NULL,
  `Evaluation_Period` date DEFAULT NULL,
  `Key_Performance_Indicators` varchar(245) DEFAULT NULL,
  `Rating` int(11) DEFAULT NULL,
  `Comments` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `performance`
--

INSERT INTO `performance` (`Performance_Id`, `Employee_Id`, `Evaluation_Period`, `Key_Performance_Indicators`, `Rating`, `Comments`) VALUES
(1, 2, '2022-12-01', 'KPI 1', 5, 'Great job!'),
(2, 1, '2022-12-02', 'KPI 2', 2, 'Well done.'),
(3, 3, '2022-12-03', 'KPI 3', 3, 'Room for improvement.'),
(4, 5, '2022-12-04', 'KPI 4', 1, 'Excellent performance.'),
(5, 4, '2022-12-05', 'KPI 5', 4, 'Good effort.');

-- --------------------------------------------------------

--
-- Table structure for table `training`
--

CREATE TABLE `training` (
  `Training_Id` int(11) NOT NULL,
  `Employee_Id` int(11) DEFAULT NULL,
  `Training_Type` varchar(300) DEFAULT NULL,
  `Trainner` varchar(85) DEFAULT NULL,
  `Duration` varchar(30) DEFAULT NULL,
  `Completion_Status` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `training`
--

INSERT INTO `training` (`Training_Id`, `Employee_Id`, `Training_Type`, `Trainner`, `Duration`, `Completion_Status`) VALUES
(1, 5, 'Onboarding', 'Joseph Gatete', '2 weeks', 'Completed'),
(2, 2, 'Technical Skills', 'Jane Goldon', '1 month', 'In Progress'),
(3, 3, 'Leadership Workshop', 'Michael James', '3 days', 'Not Started'),
(4, 4, 'Communication Skills', 'Jenifer Lily', '2 weeks', 'Completed'),
(5, 1, 'Project Management', 'Benjamin Davis', '1 month', 'Not Started'),
(6, 8, 'Human resource', 'Mr doggi', '4weeks', 'finished'),
(10, 11, 'asdfghjk', 'asdfghjk', '1week', 'zxcvbnm'),
(11, 13, 'management', 'prof hacher', '3weeks', 'finished');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`Attendance_Id`),
  ADD KEY `Employee_Id` (`Employee_Id`);

--
-- Indexes for table `benefits`
--
ALTER TABLE `benefits`
  ADD PRIMARY KEY (`Benefit_Id`),
  ADD KEY `Employee_Id` (`Employee_Id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_Id`);

--
-- Indexes for table `leave_request`
--
ALTER TABLE `leave_request`
  ADD PRIMARY KEY (`Request_Id`),
  ADD KEY `Employee_Id` (`Employee_Id`);

--
-- Indexes for table `payroll`
--
ALTER TABLE `payroll`
  ADD PRIMARY KEY (`Payroll_Id`),
  ADD KEY `Employee_Id` (`Employee_Id`);

--
-- Indexes for table `performance`
--
ALTER TABLE `performance`
  ADD PRIMARY KEY (`Performance_Id`),
  ADD KEY `Employee_Id` (`Employee_Id`);

--
-- Indexes for table `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`Training_Id`),
  ADD KEY `Employee_Id` (`Employee_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `Attendance_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `benefits`
--
ALTER TABLE `benefits`
  MODIFY `Benefit_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `Employee_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `leave_request`
--
ALTER TABLE `leave_request`
  MODIFY `Request_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `payroll`
--
ALTER TABLE `payroll`
  MODIFY `Payroll_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `performance`
--
ALTER TABLE `performance`
  MODIFY `Performance_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `training`
--
ALTER TABLE `training`
  MODIFY `Training_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`Employee_Id`) REFERENCES `employee` (`Employee_Id`);

--
-- Constraints for table `benefits`
--
ALTER TABLE `benefits`
  ADD CONSTRAINT `benefits_ibfk_1` FOREIGN KEY (`Employee_Id`) REFERENCES `employee` (`Employee_Id`);

--
-- Constraints for table `leave_request`
--
ALTER TABLE `leave_request`
  ADD CONSTRAINT `leave_request_ibfk_1` FOREIGN KEY (`Employee_Id`) REFERENCES `employee` (`Employee_Id`);

--
-- Constraints for table `payroll`
--
ALTER TABLE `payroll`
  ADD CONSTRAINT `payroll_ibfk_1` FOREIGN KEY (`Employee_Id`) REFERENCES `employee` (`Employee_Id`);

--
-- Constraints for table `performance`
--
ALTER TABLE `performance`
  ADD CONSTRAINT `performance_ibfk_1` FOREIGN KEY (`Employee_Id`) REFERENCES `employee` (`Employee_Id`);

--
-- Constraints for table `training`
--
ALTER TABLE `training`
  ADD CONSTRAINT `training_ibfk_1` FOREIGN KEY (`Employee_Id`) REFERENCES `employee` (`Employee_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
