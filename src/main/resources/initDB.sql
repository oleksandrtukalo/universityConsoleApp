CREATE TABLE `departments` (
                             `dep_id` int(11) NOT NULL,
                             `dep_name` varchar(255) DEFAULT NULL,
                             `dep_head_lec_id` int(11) DEFAULT NULL,
                             PRIMARY KEY (`dep_id`),
                             KEY `lec_head_idx` (`dep_head_lec_id`),
                             CONSTRAINT `dep_id` FOREIGN KEY (`dep_id`) REFERENCES `lector_department` (`dep_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                             CONSTRAINT `lec_head` FOREIGN KEY (`dep_head_lec_id`) REFERENCES `lectors` (`lec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `lector_department` (
                                   `lec_id` int(11) NOT NULL,
                                   `dep_id` int(11) NOT NULL,
                                   PRIMARY KEY (`lec_id`,`dep_id`),
                                   KEY `dep` (`dep_id`),
                                   CONSTRAINT `dep` FOREIGN KEY (`dep_id`) REFERENCES `departments` (`dep_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                   CONSTRAINT `lec` FOREIGN KEY (`lec_id`) REFERENCES `lectors` (`lec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `lectors` (
                         `lec_id` int(11) NOT NULL,
                         `degree` varchar(255) DEFAULT NULL,
                         `fname` varchar(255) DEFAULT NULL,
                         `lname` varchar(255) DEFAULT NULL,
                         `salary` int(11) DEFAULT NULL,
                         PRIMARY KEY (`lec_id`),
                         CONSTRAINT `lec_id` FOREIGN KEY (`lec_id`) REFERENCES `lector_department` (`lec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1